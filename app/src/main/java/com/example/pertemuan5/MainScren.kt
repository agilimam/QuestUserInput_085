package com.example.pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable


fun MainScren(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf("")}
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectGender by remember { mutableStateOf("") }

    var jenisKelamin = listOf("Laki Laki","Perempuan")
    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by remember { mutableStateOf("") }
    var noHpUser by remember{ mutableStateOf("") }
    var selectGenderUser by remember { mutableStateOf("") }


    Column (Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            label = { Text("Nama") },
            placeholder = { Text("Masukkan Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row (){
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectGender == item,
                        onClick = {
                            selectGender = item
                        })
                    Text(item)
                }
            }


        }
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Email") },
            placeholder = { Text("Masukkan Email") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email
            )
        )
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text("Alamat") },
            placeholder = { Text("Masukkan Alamat") },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        OutlinedTextField(
            value = noHp,
            onValueChange = {noHp = it},
            label = { Text("Nohp") },
            placeholder = { Text("Masukkan noHp") },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number
            )
        )

        Button(
            onClick = {
                namaUser = nama
                selectGenderUser = selectGender
                emailUser = email
                alamatUser = alamat
                noHpUser =noHp
            }
        ){ Text("Submit") }

        Card {modifier.size(width = 100.dp, height = 200.dp)
            CardSection(judulParam = "Nama", Isiparams = namaUser)
            CardSection(judulParam = "Email", Isiparams = emailUser)
            CardSection(judulParam = "Jenis Kelamin", Isiparams = selectGenderUser)
            CardSection(judulParam = "Alamat", Isiparams = alamatUser)
            CardSection(judulParam = "No HP" , Isiparams = noHpUser)


        }

    }

}
@Composable
fun CardSection(judulParam : String, Isiparams :String) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = "$Isiparams", modifier = Modifier.weight(2f))
        }

    }
}


