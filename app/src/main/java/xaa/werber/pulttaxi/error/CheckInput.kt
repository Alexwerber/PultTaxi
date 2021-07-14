package xaa.werber.pulttaxi.error

class CheckInput {
    companion object {
        fun checkPhoneNumber(number: String): Boolean {
            return number.length == 10
        }

        fun checkSMSCode(sms: String): Boolean {
            return sms.length == 4
        }
    }
}