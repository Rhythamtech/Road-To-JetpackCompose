
# Simple Screen Navigation in Jetpack Compose

Jetpack Compose is a modern, declarative framework for building native Android UIs. In this blog post, we will explore how to implement navigation in Jetpack Compose using the Navigation Component.

## Setting up the project

First, you need to add the Navigation dependency to your `build.gradle` file:

```kotlin
dependencies {
	 // Other Dependencies....
	 
	 def nav_version =  "2.5.3" 
	 implementation("androidx.navigation:navigation-compose:$nav_version")  
}
```

Make sure to use compatible versions of Jetpack Compose and Navigation. For example, the Navigation version should be in April 2023 is  `2.5.3`.

## The Navigation Component

The Navigation Component consists of three parts: `NavController`, `NavHost`, and the navigation graph. The `NavController` is responsible for managing the navigation stack, while the `NavHost` is a container for your composable screens.

### Creating the navigation graph

In Jetpack Compose, the navigation graph is built using the lambda syntax from the Navigation Kotlin DSL instead of XML. The navigation graph is constructed in the trailing lambda passed to `NavHost` as shown below:

```kotlin
NavHost(navController = navController, startDestination = "home") {
   composable("home") { MealsListScreen() }
   composable("details") { MealDetailsScreen() }
}
```

In this example, the `MealsListScreen()` composable is associated with the route defined by the `String "home"`, and the `MealDetailsScreen()` composable is associated with the "details" route. The `startDestination` is set to "home", meaning that the `MealsListScreen()` composable will be displayed when the app launches .

### Creating a composable function for navigation

Create a composable function named `ComposeNavigation()` that will handle the navigation between different screens:

```kotlin
@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "first_screen"
    ) {
        composable("first_screen") {
            FirstScreen(navController = navController)
        }
        composable("second_screen") {
            SecondScreen(navController = navController)
        }
        composable("third_screen") {
            ThirdScreen(navController = navController)
        }
    }
}
```

Call the `ComposeNavigation()` method from the `setContent` block in your `MainActivity`:

```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
        ComposeNavigationTheme {
            ComposeNavigation()
        }
    }
}
```

### Navigating between screens

To navigate between screens, use the `navController` to navigate to the desired route using the `navigate()` method:

```kotlin
@Composable
fun FirstScreen(navController: NavController) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "First Screen\n" +
      "Click me to go to Second Screen",
      style = TextStyle(textAlign = TextAlign.Center),
      modifier = Modifier.clickable(onClick = {
        // this will navigate to the second screen
        navController.navigate("second_screen")
      })
    )
  }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Second Screen\n" +
                    "Click me to go to Third Screen",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.clickable(onClick = {
                // this will navigate to third screen
                navController.navigate("third_screen")
            })
        )
    }
}

@Composable
fun ThirdScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Third Screen",
            color = Color.Green,
            style = TextStyle(fontSize = 30.sp),
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

```

Don't forget to import the `navigate()` method if your IDE doesn't do it automatically:

```kotlin
import androidx.navigation.compose.navigate
```

Now, when you run the app and tap on the text, you will navigate to a different screen. Press the back button to verify if the back stack is being maintained.

In conclusion, navigation in Jetpack Compose is simple and straightforward. By using the Navigation Component and creating a navigation graph, you can easily handle navigation between different screens in your app.
Simple Screen Navigation in Jetpack Compose
Jetpack Compose is a modern, declarative framework for building native Android UIs. In this blog post, we will explore how to implement navigation in Jetpack Compose using the Navigation Component.

Setting up the project
First, you need to add the Navigation dependency to your build.gradle file:

dependencies {
// Other Dependencies....

	 def nav_version =  "2.5.3" 
	 implementation("androidx.navigation:navigation-compose:$nav_version")  
}
Make sure to use compatible versions of Jetpack Compose and Navigation. For example, the Navigation version should be in April 2023 is 2.5.3.

The Navigation Component
The Navigation Component consists of three parts: NavController, NavHost, and the navigation graph. The NavController is responsible for managing the navigation stack, while the NavHost is a container for your composable screens.

Creating the navigation graph
In Jetpack Compose, the navigation graph is built using the lambda syntax from the Navigation Kotlin DSL instead of XML. The navigation graph is constructed in the trailing lambda passed to NavHost as shown below:
```
NavHost(navController = navController, startDestination = "home") {
composable("home") { MealsListScreen() }
composable("details") { MealDetailsScreen() }
}
```
In this example, the MealsListScreen() composable is associated with the route defined by the String "home", and the MealDetailsScreen() composable is associated with the “details” route. The startDestination is set to “home”, meaning that the MealsListScreen() composable will be displayed when the app launches .

Creating a composable function for navigation
Create a composable function named ComposeNavigation() that will handle the navigation between different screens:

```
@Composable
fun ComposeNavigation() {
val navController = rememberNavController()
NavHost(
navController = navController,
startDestination = "first_screen"
) {
composable("first_screen") {
FirstScreen(navController = navController)
}
composable("second_screen") {
SecondScreen(navController = navController)
}
composable("third_screen") {
ThirdScreen(navController = navController)
}
}
}
Call the ComposeNavigation() method from the setContent block in your MainActivity:

override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContent {
ComposeNavigationTheme {
ComposeNavigation()
}
}
}
Navigating between screens
To navigate between screens, use the navController to navigate to the desired route using the navigate() method:

@Composable
fun FirstScreen(navController: NavController) {
Column(
modifier = Modifier.fillMaxSize(),
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally
) {
Text(
text = "First Screen\n" +
"Click me to go to Second Screen",
style = TextStyle(textAlign = TextAlign.Center),
modifier = Modifier.clickable(onClick = {
// this will navigate to the second screen
navController.navigate("second_screen")
})
)
}
}

@Composable
fun SecondScreen(navController: NavController) {
Column(
modifier = Modifier.fillMaxSize(),
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally
) {
Text(
text = "Second Screen\n" +
"Click me to go to Third Screen",
style = TextStyle(textAlign = TextAlign.Center),
modifier = Modifier.clickable(onClick = {
// this will navigate to third screen
navController.navigate("third_screen")
})
)
}
}

@Composable
fun ThirdScreen(navController: NavController) {
Column(
modifier = Modifier.fillMaxSize(),
verticalArrangement = Arrangement.Center,
horizontalAlignment = Alignment.CenterHorizontally
) {
Text(
text = "Third Screen",
color = Color.Green,
style = TextStyle(fontSize = 30.sp),
modifier = Modifier.padding(bottom = 16.dp)
)
}
}
```
Don’t forget to import the navigate() method if your IDE doesn’t do it automatically:
```
import androidx.navigation.compose.navigate
```
Now, when you run the app and tap on the text, you will navigate to a different screen. Press the back button to verify if the back stack is being maintained.

In conclusion, navigation in Jetpack Compose is simple and straightforward. By using the Navigation Component and creating a navigation graph, you can easily handle navigation between different screens in your app.

