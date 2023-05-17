## SearchBar() Compose:

`SearchBar()` is a composable function Jetpack Compose in Android. `SearchBar` allows a user to find information from the List of data in an app. Users just input the search term or query into the `SearchBar` and see related results.

```kotlin
@ExperimentalMaterial3Api
@Composable
fun SearchBar(
    query: String, //required 
    onQueryChange: (String) -> Unit, //required 
    onSearch: (String) -> Unit, //required 
    active: Boolean, //required 
    onActiveChange: (Boolean) -> Unit, //required 
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: Shape = SearchBarDefaults.inputFieldShape,
    colors: SearchBarColors = SearchBarDefaults.colors(),
    tonalElevation: Dp = SearchBarDefaults.Elevation,
    windowInsets: WindowInsets = SearchBarDefaults.windowInsets,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable ColumnScope.() -> Unit,
)
```

### Some important parameters of SearchBar():

1. `query`: is a String that the user input text for Search in Search Bar.

2. `onQueryChange`: it is a state invoked when the input service updates the query. An updated text comes as a parameter of the callback.

3. `onSearch`: when the user clicks on press search ImeAction on the Keyboard.

4. `active:` whether this search bar is active or not. Example: `true` or `false`.

5. `onActiveChange:` update this search bar's active state to be changed from `false` to `true` or vice versa.

6. `enable`: our `SearchBar` enabled or not.

7. `placeholder`: is a short hint that describes the expected value of a search field.


## Let's implement SpaceBar() Composable:

Create a `text` variable is created using the `remember` function with `MutableState` object that holds a value and can be updated, and initialized with an empty string. This variable holds the current value of the search bar.

```kotlin
var text by remember { mutableStateOf("") } // Query for SearchBar
```

And create an another `active` variable is also created using the `remember` the function and initialized with `false`. This variable holds the current active state of the `SearchBar`.

```kotlin
var active by remember { mutableStateOf(false) } // Active state for SearchBar
```

There is how final code looks like :

```kotlin
SearchBar(modifier = Modifier.fillMaxWidth(),
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Enter your query")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }) {}
```

After, this basic implementation let's add some features like `trailingIcon`, `leadingIcon`, `placeholder`, search history, etc....

1. **add Trailing Icon**:

   As a trailing icon, I am using `Icons.Default.Close`. Let's discuss the features,

   If the `SearchBar()` state is `active` then the icon will visible, when we click on the icon. It checks if the `text` or query is not empty then make `text` empty else make the `active` state to `false`.


```kotlin
trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (text.isNotEmpty()) {
                                text = ""
                            } else {
                                active = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close icon"
                    )
                }
            }
```

1. **add leading Icon**:

    ```kotlin
    leadingIcon = {
        Icon(imageVector = Icons.Default.Search, contentDescription = "Search icon")
    }
    ```

2. **add Placeholder**:

    ```kotlin
    placeholder = {
        Text(text = "Enter your query")
    }
    ```

3. **add search history**:

   For adding search history, create a variable `searchHistory` of type `mutableStateListOf`.

    ```kotlin
    var searchHistory = remember { mutableStateListOf("") }
    ```

   For the history icon we need to implement extended material Icons dependency.

    ```kotlin
    // build.gradle(:app)    
    implementation 'androidx.compose.material:material-icons-extended:1.4.3'
    ```

   After adding a dependency, inside the SearchBar() composable:

    ```kotlin
    SearchBar(
    // functional body
    ){
     searchHistory.forEach {
                    if (it.isNotEmpty()) {
                        Row(modifier = Modifier.padding(all = 14.dp)) {
                            Icon(imageVector = Icons.Default.History,           contentDescription = null)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = it)
                        }
                    }
                }
    }
    ```

   It's look like this:


![](https://cdn.hashnode.com/res/hashnode/image/upload/v1684336087906/06567f07-f047-486d-870b-2d8618a9796c.jpeg align="center")

1. **add Clear search history button**:

   For this creates a clickable Text element that clears the `searchHistory` list when clicked.

    ```kotlin
    Divider()
    Text(
           modifier = Modifier
            .padding(all = 14.dp)
            .fillMaxWidth()
            .clickable {
                    searchHistory.clear()
                 },
           textAlign = TextAlign.Center,
           fontWeight = FontWeight.Bold,
           text = "clear all history"
         )
    ```