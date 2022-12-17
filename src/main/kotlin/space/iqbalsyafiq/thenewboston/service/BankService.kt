package space.iqbalsyafiq.thenewboston.service

import org.springframework.stereotype.Service
import space.iqbalsyafiq.thenewboston.datasource.BankDataSource
import space.iqbalsyafiq.thenewboston.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)

}