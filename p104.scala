class CustomerAccount(var balance: Double) {

  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $$${amount}. New balance: $$${balance}.")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}.")
    } else if (amount > balance) {
      println("Insufficient balance.")
    } else {
      println("Withdraw amount must be positive.")
    }
  }

  // Method to transfer money from this account to another account
  def transfer(amount: Double, toAccount: CustomerAccount): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to another account. Your new balance: $$${this.balance}.")
    } else {
      println("Transfer failed due to insufficient balance or invalid amount.")
    }
  }

  // Method to apply interest based on balance
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05 // Positive balance, apply 5% interest
    } else {
      balance += balance * 0.1 // Negative balance, apply 10% overdraft interest
    }
  }

  override def toString: String = s"Account balance: $$${balance}"
}

class FinancialInstitution(var accounts: List[CustomerAccount]) {

  // 4.1 List of Accounts with negative balances
  def accountsWithNegativeBalances: List[CustomerAccount] = accounts.filter(_.balance < 0)

  // 4.2 Calculate the sum of all account balances
  def totalBalance: Double = accounts.map(_.balance).sum

  // 4.3 Calculate the final balances after applying interest
  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  // Display balances of all accounts
  def printAllBalances(): Unit = {
    accounts.foreach(acc => println(acc.toString))
  }
}

object FinancialInstitutionTest extends App {
  val acc1 = new CustomerAccount(500.0) // Account with $500
  val acc2 = new CustomerAccount(-100.0) // Account with -$100
  val acc3 = new CustomerAccount(200.0) // Account with $200

  val bank = new FinancialInstitution(List(acc1, acc2, acc3))

  // 4.1 List accounts with negative balances
  val negativeAccounts = bank.accountsWithNegativeBalances
  println("Accounts with negative balances:")
  negativeAccounts.foreach(acc => println(acc.toString))

  // 4.2 Calculate the sum of all account balances
  println(s"Total balance of all accounts: $$${bank.totalBalance}")

  // 4.3 Apply interest to all accounts and display final balances
  bank.applyInterestToAllAccounts()
  println("Balances after applying interest:")
  bank.printAllBalances()
}
