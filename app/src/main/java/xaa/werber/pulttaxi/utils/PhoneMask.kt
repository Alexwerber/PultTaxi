package xaa.werber.pulttaxi.utils

class PhoneMask {
    companion object {
        fun russianPhoneNumber(number: String): String {
            return "7$number"
        }
    }
}