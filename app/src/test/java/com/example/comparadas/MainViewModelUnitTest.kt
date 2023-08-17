package com.example.comparadas

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.comparadas.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Test
import org.junit.Rule
import org.junit.After
import org.junit.Before
import org.junit.Assert.*

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.comparator.value?.isEqualMessage
        assertEquals("...", value)
    }

    @Test
    fun mainViewModel_TestPositiveCompare() = runTest {
        launch {
            viewModel.compare("","")
        }

        advanceUntilIdle()

        val value = viewModel.comparator.value?.isEqualMessage
        assertEquals("Son iguales!", value)
    }

    @Test
    fun mainViewModel_TestNegativeCompare() = runTest {
        launch {
            viewModel.compare("1","")
        }

        advanceUntilIdle()

        val value = viewModel.comparator.value?.isEqualMessage
        assertEquals("Son Diferentes...", value)
    }
}