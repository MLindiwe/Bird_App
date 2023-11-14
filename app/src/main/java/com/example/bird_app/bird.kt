package recycleview.application

import android.os.Parcel
import android.os.Parcelable

data class bird(val image: Int ,  val name: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<bird> {
        override fun createFromParcel(parcel: Parcel): bird {
            return bird(parcel)
        }

        override fun newArray(size: Int): Array<bird?> {
            return arrayOfNulls(size)
        }
    }
}
