package erthru.mvpexample

import android.text.TextUtils

class MainPresenterImp(private val view:MainView) : MainPresenter{

    // sebuah arraylist utk menampung data
    private val DATA = ArrayList<HashMap<String,String>>()


    // overide mthod add data yang ada pada interface presenter
    override fun addData(firstName: String, lastName: String) {

        if(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName)){
            // meamanggil view untuk menampilkan pesan saat salah satu dari edittext kosong
            view.showMessage("Field tidak boleh kosong")
        }else{

            // hashmap
            val map = HashMap<String, String>()

            // menambahkan 2 value pada hashmap
            map.put("firstname",firstName)
            map.put("lastname",lastName)

            // data hashmap yang telah diisi value ditampung ke arraylist
            DATA.add(map)

            // memanggil view untuk menampilkan pesan saat data ditambahkan
            view.showMessage("Data ditambahkan")

            // memanggil view untuk clear edittext
            view.clearField()
        }
    }


    // override method load data yang ada pada interdace presenter
    override fun loadData() {

        if(DATA.size == 0){
            // memanggil view untuk menampilkan pesan saat data pada arraylist masih kosong
            view.showMessage("Data kosong")
        }else{

            // sebuah variable string dengan nama allData
            var allData = ""

            // melakukan for loop untuk mengisi sebuah variabel allData dengan setiap value yang ada pada arraylist
            for(i in 0 until DATA.size){
                allData += "Nama Depan : "+DATA[i].get("firstname")+"\nNama Belakang : "+DATA[i].get("lastname")+"\n\n"
            }

            // menampilkan jumlah value yang ada pada arraylist
            allData += "Total : "+DATA.size

            // memanggil view untuk menampilkan data
            view.showData(allData)

        }

    }


}