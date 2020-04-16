package com.gluthfi.sbdm_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MhsDatabase(this)

        GlobalScope.launch {
            db.mhsDao().insertAll(MhsEntity(0, "Budi", "Malang"))
            val data = db.mhsDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }

        addBtn.setOnClickListener {

            var nama = namaEt.text.toString()
            var alamat = alamatEt.text.toString()

//            i_result.setText("nama = $nama \nalamat = $alamat")

            GlobalScope.launch {
                db.mhsDao().insertAll(MhsEntity(0, "$nama", "$alamat"))
                val data = db.mhsDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }
        }
    }
}
