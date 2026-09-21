package isel.dei.pdm.demos.demo8puzzle.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import isel.dei.pdm.demos.demo8puzzle.ui.theme.Demo8PuzzleTheme
import org.junit.Rule
import org.junit.Test

class PuzzleScreenTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun screen_starts_in_idle_state() {
        // Arrange & Act
        val viewModel = PuzzleScreenViewModel()
        composeTestRule.setContent {
            Demo8PuzzleTheme {
                PuzzleScreen(viewModel = viewModel)
            }
        }

        // Assert
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(RESET_BUTTON_TAG).assertDoesNotExist()
        composeTestRule.onNodeWithTag(SOLVE_BUTTON_TAG).assertDoesNotExist()
    }

    @Test
    fun clicking_start_transitions_to_solving_state() {
        // Arrange
        val viewModel = PuzzleScreenViewModel()
        composeTestRule.setContent {
            Demo8PuzzleTheme {
                PuzzleScreen(viewModel = viewModel)
            }
        }

        // Act
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).performClick()

        // Assert
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).assertDoesNotExist()
        composeTestRule.onNodeWithTag(RESET_BUTTON_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(SOLVE_BUTTON_TAG).assertIsDisplayed()
    }

    @Test
    fun clicking_reset_transitions_back_to_idle_state() {
        // Arrange
        val viewModel = PuzzleScreenViewModel()
        composeTestRule.setContent {
            Demo8PuzzleTheme {
                PuzzleScreen(viewModel = viewModel)
            }
        }
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).performClick()

        // Act
        composeTestRule.onNodeWithTag(RESET_BUTTON_TAG).performClick()

        // Assert
        composeTestRule.onNodeWithTag(START_BUTTON_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(RESET_BUTTON_TAG).assertDoesNotExist()
        composeTestRule.onNodeWithTag(SOLVE_BUTTON_TAG).assertDoesNotExist()
    }
}
