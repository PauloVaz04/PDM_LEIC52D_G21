# Course Plan (draft)

* **Academic Term:** 07/09/2026 to 19/12/2026
* **Assignment Publication:** 14/09/2026
* **Deadline for Assignments:** 12/12/2026
* **Discussions from:** 14/12/2026

---

## Week 1 (07/09/2026)
* **Topic: Presentation** - Goals, context, teaching methodology, evaluation rules, and workspace preparation.
* **Topic: Anatomy of an Android application** - Activity component (UI host), Android project composition, and "Hello Android" demo using the wizard.
* **Topic: UI Construction with Jetpack Compose** - State, stateless composables, basic elements (Text, Button), layouts (Row, Column, Box), UI event handling, and separation between domain and UI.
* **Demos:** The value of immutability, automated testing (domain and UI), and 8-Puzzle demo (single Activity, no view-model, stateless composables).
* **For Reference:** Links for Android Studio, API Levels, Compose layout basics, UI testing, Compose previews, and Prodigi course modules.

## Week 2 (14/09/2026)
* **Topic: UI Construction with Jetpack Compose** - Stateful composables, presentation state management (remember and mutableStateOf), state hoisting, and composable lifecycle/recomposition.
* **Topic: Design & Concurrency** - Implementing the screen as a state machine, Jetpack Compose concurrency, and Kotlin concurrency (Threads, Coroutines, Dispatchers, Scopes, Main/UI thread, LaunchedEffect).
* **Demos:** 8-Puzzle demo (implementing IdleView, SolvingView, SolvedView, and PlayScreen as the state machine host).
* **For Reference:** State and Jetpack Compose documentation, and Prodigi state modules.

## Week 3 (21/09/2026)
* **Topic: Activity Component** - Lifecycle (onCreate, onStart, onStop, onDestroy), reconfiguration behavior, and implications for state management.
* **Topic: Compose UI & Architecture** - Presentation state preservation (rememberSaveable), application vs. presentation state, UI architecture, multiple orientations, and application resources (multi-language text, images).
* **Topic: MVVM Pattern in Android** - ViewModel purpose, lifecycle, ViewModelStore, and its role as a domain interlocutor and UI state host.
* **Demos:** 8-Puzzle demo using a ViewModel to host the screen's state machine via MutableState.
* **For Reference:** App architecture guides, ViewModel lifecycle, Material Design 3, and Prodigi Activity/ViewModel modules.

## Week 4 (28/09/2026)
* **Topic: Compose UI & Navigation** - Activity lifecycle during navigation, user tasks, back stack, explicit/implicit Intents, and CompositionLocal (LocalConfiguration, MaterialTheme, etc.).
* **Topic: Automated Testing** - Automated tests for navigation between activities.
* **Demos:** 8-Puzzle demo with multiple activities (StartActivity and AboutActivity).
* **For Reference:** Tasks and back stack, Intents, CompositionLocal documentation.

## Week 5 (05/10/2026)
* **Topic: Practical Assignment Follow-up** - Students must record a video up to 7 minutes presenting their application.
* **Presentation Requirements:** Implemented features, main decisions, testing strategy, and planning for remaining tasks.

## Week 6 (12/10/2026)
* **Topic: Android Concurrency Model** - Lifecycle callback execution, event handlers, and Kotlin concurrency review (Threads, suspending functions, flows, StateFlow).
* **Topic: Reactive Architecture** - ViewModel as an execution host (viewModelScope) and UI state flow host, plus updating the UI via StateFlow.collectAsStateWithLifecycle().
* **Demos:** 8-Puzzle demo with incremental automatic resolution (LRTA*) to justify flows, adding a Solving state, and using reactive architecture from domain to UI.
* **For Reference:** Asynchronous Flow, Kotlin flows on Android, and Coroutine/Flow testing documentation.

## Week 7 (19/10/2026)
* **Topic: State Management (Cont.)** - User facing vs. non user facing work, automatic resource management consequences, and revisiting lifecycles/back stack.
* **Topic: Dependency Resolution** - Dependency injection motivation, and using the Application class as a Service Locator.
* **Demos:** 8-Puzzle process termination/background behavior, Compose Navigation 3 refactoring, and MyGame Vault demo setup using fake services and Application-based dependency resolution.
* **For Reference:** App lifecycle, Parcelables, Navigation 3, and Manual dependency injection documentation.

## Week 8 (26/10/2026)
* **Topic: HTTP API Communication** - Android as an HTTP client, necessary permissions, Ktor programming model, async requests, and Kotlin JSON Serialization.
* **Topic: Design Considerations** - DTOs vs Domain Objects, secrets distribution (BYOK, Backend Proxy, Remote Config, local.properties), error handling/failure models, and observability.
* **Demos:** MyGame Vault demo implementing the IGDB API service, error handling, and basic logging.
* **For Reference:** Network connection, Ktor Client, Ktor Engines, Content Negotiation, and Kotlin Serialization documentation.

## Week 9 (02/11/2026)
* **Topic: Persistent Device Storage** - DataStore (key-value pairs, low-volume unstructured data) and Room (relational database).
* **Demos:** MyGame Vault Collection demo (defining domain elements, in-memory repository, and Room repository).
* **For Reference:** App Architecture Data Layer, DataStore, and Room documentation.

## Week 10 (09/11/2026)
* **Topic: Practical Assignment Follow-up** - Students must record a video up to 7 minutes covering implemented features, decisions, verification strategy, and planning.

## Week 11 (16/11/2026)
* **Topic: Background Tasks** - Android process classification (foreground, visible, service, cached), and the Work Manager API (task scheduling and Coroutine Worker concurrency).
* **Demos:** MyGameVault demo implementing playtime tracking.
* **For Reference:** Background work, Task scheduling, and CoroutineWorker documentation.

## Week 12 (23/11/2026)[cite: 3]
* **Topic: Background Tasks (Cont.)** - Foreground Services (motivation, concurrency) and Notifications (motivation, applicability)[cite: 3].
* **Demos:** Refining MyGameVault playtime tracking to maintain a notification with a timer[cite: 3].
* **For Reference:** Foreground services and Jetpack Compose Notifications documentation[cite: 3].

## Week 13 (30/11/2026)[cite: 3]
* **Topic: Android Programming Model** - Presentation of remaining Android model elements and consolidation of the My Game Vault demo[cite: 3].

## Week 14 (07/12/2026)[cite: 3]
* **Topic: Practical Assignment Follow-up** - Students must conclude development and record a final video up to 7 minutes demonstrating the application and discussing main decisions[cite: 3].

## Week 15 (14/12/2026)[cite: 3]
* **Topic: Discussions** - Final project discussions[cite: 3].