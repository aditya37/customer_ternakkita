package com.ternakkita.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class data_user {
        @SerializedName("imageThumbnail")
        @Expose
        private String imageThumbnail;
        @SerializedName("judul_produk")
        @Expose
        private String judulProduk;
        @SerializedName("nama_customer")
        @Expose
        private String namaCustomer;
        @SerializedName("alamat_customer")
        @Expose
        private String alamatCustomer;

        public String getImageThumbnail() {
            return imageThumbnail;
        }

        public void setImageThumbnail(String imageThumbnail) {
            this.imageThumbnail = imageThumbnail;
        }

        public String getJudulProduk() {
            return judulProduk;
        }

        public void setJudulProduk(String judulProduk) {
            this.judulProduk = judulProduk;
        }

        public String getNamaCustomer() {
            return namaCustomer;
        }

        public void setNamaCustomer(String namaCustomer) {
            this.namaCustomer = namaCustomer;
        }

        public String getAlamatCustomer() {
            return alamatCustomer;
        }

        public void setAlamatCustomer(String alamatCustomer) {
            this.alamatCustomer = alamatCustomer;
        }
}
