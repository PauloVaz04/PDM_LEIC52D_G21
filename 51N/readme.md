# [Moodle](https://2627moodle.isel.pt/course/view.php?id=11145)

# Outline

## Week 1 - 07/09/2026
### Subject: Course introduction and Android Development 101

#### Topic breakdown:
* Syllabus, teaching methodology and bibliography.
  * Evaluation
  * Resources
* The Activity component as the UI host
  * Basic lifecycle: onCreate, onStart, onStop and onDestroy
* Jetpack Compose (revisions from TDS course)
  * @Composable functions: the building blocks of the UI
  * Mental model: the UI as a function of state (state -> @Composable -> UI)
  * Stateless @Composable functions
    * Elementary UI elements: Text, Button, Image
    * Layouts: Column, Row, Box

#### For reference:
* [Download Android Studio & App Tools](https://developer.android.com/studio)
* [Android API Levels](https://apilevels.com/)
* [SDK Platform release notes | Android Developers](https://developer.android.com/studio/releases/platforms)
* [Coding Conventions | Kotlin Documentation](https://kotlinlang.org/docs/coding-conventions.html)
* [Thinking in Compose | Jetpack Compose | Android Developers](https://developer.android.com/develop/ui/compose/mental-model)
* [Material components in Compose](https://developer.android.com/develop/ui/compose/components)
* [Compose Layout Basics](https://developer.android.com/develop/ui/compose/layouts/basics)
* [Preview your UI with composable previews | Jetpack Compose | Android Developers](https://developer.android.com/develop/ui/compose/tooling/previews)


## Week 2 - 14/09/2026
### Subject: Building a UI with Jetpack Compose - Introduction

#### Topic breakdown:
* Architecting the UI: introduction
* Jetpack Compose
  * Stateless vs. stateful @Composables, `remember` and `mutableStateOf` 
  * State hoisting: lifting the state to the parent composable
* Architecting the UI: introduction

#### For reference:
* [Thinking in Compose | Jetpack Compose | Android Developers](https://developer.android.com/develop/ui/compose/mental-model)
* [Material components in Compose](https://developer.android.com/develop/ui/compose/components)
* [Compose Layout Basics](https://developer.android.com/develop/ui/compose/layouts/basics)
* [Preview your UI with composable previews | Jetpack Compose | Android Developers](https://developer.android.com/develop/ui/compose/tooling/previews)
* [State and Jetpack Compose](https://developer.android.com/develop/ui/compose/state#state-and-composition)
* [Architecting your Compose UI](https://developer.android.com/develop/ui/compose/architecture)
* [Guide to app architecture](https://developer.android.com/topic/architecture)


## Week 3 - 21/09/2026
### Subject: Building a UI with Jetpack Compose - Continuation

#### Topic breakdown:
* Architecting the UI: continuation
  * Immutability
  * View States
* Automatic testing in Android
  * Unit tests with JUnit
  * Instrumented UI tests
  * Testing @Composable functions with Compose Testing

#### For reference:
* [State and Jetpack Compose | Android Developers](https://developer.android.com/develop/ui/compose/state#managing-state) 
* [Architecting your Compose UI | Jetpack Compose | Android Developers](https://developer.android.com/jetpack/compose/architecture)
* [Guide to application architecture](https://developer.android.com/jetpack/guide)
* [Test your Compose layout](https://developer.android.com/develop/ui/compose/testing) 
* [Test apps on Android](https://developer.android.com/training/testing)