package at.topc.tado.data.zone.device

enum class TadoDeviceType {
    RU02, // Wired thermostat v2
    VA02, // Smart Radiator Thermostat v2
    SU02, // Wireless temperature sensor
    BR02, // Wireless receiver (Boiler)
    BP02, // Wireless receiver (Programmer)
    IB01, // Internet bridge
    WR02, // Smart AC Control v2

    /**
     * Inactive products
     */
    RU01, // Wired thermostat v1
    VA01, // Smart Radiator Thermostat v1
    BU01, // Extension kit v1
    BU02, // Extension kit v2
    WR01 // Smart AC Control v1
}
