package space.iqbalsyafiq.thenewboston.datasource.mock

import org.springframework.stereotype.Repository
import space.iqbalsyafiq.thenewboston.datasource.BankDataSource
import space.iqbalsyafiq.thenewboston.model.Bank

@Repository
class MockBankDataSource : BankDataSource {

    private val banks = mutableListOf(
        Bank("1234", 1.4, 22),
        Bank("2313", 8.2, 10),
        Bank("3112", 4.2, 8),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank = banks.firstOrNull {
        it.accountNumber == accountNumber
    } ?: throw NoSuchElementException("Couldn't find account number $accountNumber.")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with ${bank.accountNumber} has been created before.")
        }

        banks.add(bank)

        return bank
    }
}