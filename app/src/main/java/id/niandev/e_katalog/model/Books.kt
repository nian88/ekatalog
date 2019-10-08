package id.niandev.e_katalog.model

import android.os.Parcel
import android.os.Parcelable

data class Books(
    var gambar: String,
    var id: Int,
    var judul: String,
    var penerbit: String,
    var pengarang: String,
    var sinopsis: String,
    var tahun: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gambar)
        parcel.writeInt(id)
        parcel.writeString(judul)
        parcel.writeString(penerbit)
        parcel.writeString(pengarang)
        parcel.writeString(sinopsis)
        parcel.writeInt(tahun)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Books> {
        override fun createFromParcel(parcel: Parcel): Books {
            return Books(parcel)
        }

        override fun newArray(size: Int): Array<Books?> {
            return arrayOfNulls(size)
        }
    }
}