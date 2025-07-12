package ru.ari.fintracker.feature.manage_transaction.ui.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.ari.fintracker.core.di.component.CoreComponentProvider
import ru.ari.fintracker.core.ui.components.FinTrackerTopBar
import ru.ari.fintracker.feature.categories.di.DaggerCategoriesComponent
import ru.ari.fintracker.feature.manage_transaction.R
import ru.ari.fintracker.feature.manage_transaction.di.DaggerManageTransactionComponent
import ru.ari.fintracker.feature.manage_transaction.di.viewmodel.ManageTransactionViewModelFactory
import ru.ari.fintracker.feature.manage_transaction.ui.presentation.components.ManageTransactionScreen
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.ManageTransactionViewModel
import ru.ari.fintracker.feature.manage_transaction.ui.viewmodel.contract.ManageTransactionAction

@Composable
fun ManageTransactionScreenWrapper(
    onCancelButtonClick: () -> Unit,
    isIncome: Boolean,
    transactionId: Long? = null
) {
    // тут не получится создать viewmodel используя rememberDaggerViewModel,
    // т.к. мы предоставляем аргумент isIncome в рантайме
    val coreDeps = (LocalContext.current.applicationContext as CoreComponentProvider).coreComponent

    val categoriesDeps = DaggerCategoriesComponent
        .factory()
        .create(coreDeps)

    val component = remember {
        DaggerManageTransactionComponent.factory().create(
            coreDeps,
            categoriesDeps
        )
    }

    val assistedFactory = component.manageTransactionViewModelAssistedFactory()

    val viewModel: ManageTransactionViewModel = viewModel(
        factory = remember {
            ManageTransactionViewModelFactory(assistedFactory, isIncome, transactionId)
        }
    )


    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            val currentTitle =
                if (isIncome) stringResource(R.string.my_income_title) else stringResource(
                    R.string.my_expenses_title
                )
            FinTrackerTopBar(
                title = currentTitle,
                leadingIcon = ImageVector.vectorResource(R.drawable.close_icon),
                onLeadingIconClick = onCancelButtonClick,
                trailingIcon = ImageVector.vectorResource(R.drawable.accept_icon),
                onTrailingIconClick = {
                    viewModel.onAction(ManageTransactionAction.CompleteEdit(onCancelButtonClick))
                }
            )
        }
    ) { innerPadding ->
        ManageTransactionScreen(
            uiState = uiState,
            onAction = viewModel::onAction,
            isEditMode = transactionId != null,
            isIncome = isIncome,
            onDeleted = onCancelButtonClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}