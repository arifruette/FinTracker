package ru.ari.fintracker.feature.history.ui.viewmodel.contract

import ru.ari.fintracker.core.domain.models.Transaction
import java.time.LocalDate

/**
 * Модель состояния UI для экрана истории транзакций.
 * Содержит все данные, необходимые для отображения экрана истории операций
 * @property dateStart Начальная дата периода фильтрации
 * @property dateEnd Конечная дата периода фильтрации
 * @property transactions Список транзакций за период (отсортированный)
 * @property amount Итоговая сумма доходов/расходов
 * @property currency Символ валюты для отображения
 * @property isLoading Флаг активности загрузки:
 *   - true: показать индикатор загрузки
 *   - false: скрыть индикатор
 * @property errorMessage Сообщение об ошибке или null при отсутствии
 */
data class HistoryState(
    val dateStart: LocalDate = LocalDate.now().withDayOfMonth(1),
    val dateEnd: LocalDate =  LocalDate.now(),
    val transactions: List<Transaction> = emptyList(),
    val amount: Double = 0.0,
    val currency: String = "₽",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
