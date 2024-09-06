class Account(var balance: Double) {

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
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to another account. Your new balance: $$${this.balance}.")
    } else {
      println("Transfer failed due to insufficient balance or invalid amount.")
    }
  }

  override def toString: String = s"Account balance: $$${balance}"
}

object AccountTest extends App {
  val acc1 = new Account(500.0) // Account with $500
  val acc2 = new Account(300.0) // Account with $300

  acc1.deposit(200)       // Deposit $200 to acc1
  acc1.withdraw(100)      // Withdraw $100 from acc1
  acc1.transfer(200, acc2) // Transfer $200 from acc1 to acc2

  println(acc1) // Print acc1's balance
  println(acc2) // Print acc2's balance
}
