package Classes

class Camera {
    private var power: Boolean = false
    private var flash: Boolean = false
    private var resolution: Int = 640
    private var brand: String = "Cannon"

    fun getCameraStatus(): String {
        return if (power)"Camera is turned" else "Camera is not turned"
    }
    fun setCameraStatus(onOff: Boolean){
        power = onOff
    }
    fun getFlashStatus(): String {
        return if (flash)"Flash is turned" else "Flash is not turned"
    }
    fun setFlashStatus(onOff: Boolean){
        flash = onOff
    }
    fun getResolution(): Int {
        return this.resolution
    }
    fun setResolution(resolution: Int){
        this.resolution = resolution
    }
    fun getBrandStatus():String {
        return brand
    }
    fun setBrandStatus(newBrand: String){
        brand = newBrand
    }
}