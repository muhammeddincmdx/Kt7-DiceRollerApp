package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import java.lang.Math.random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceApp()
                }
            }
        }
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
{
    var result by remember{ mutableStateOf(1) }

    val image = when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else ->R.drawable.dice_6
    }

    Column (modifier = Modifier.fillMaxSize() ,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Image(painter = painterResource(id = image) , contentDescription =result.toString())
        Spacer(modifier = Modifier.height(16.dp))//boşluk oluşturma
        Button(onClick = { result=(1..6).random()}) {
            Text(stringResource(id = R.string.Roller),)
        }
    }

}

/**
 * remember ve mutableStateOf burada, kullanıcının butona her bastığında zarın yeni bir değer alması gerektiği durumu için kullanılıyor.
 * Öncelikle, result değişkeni mutableStateOf ile tanımlanıyor.
 * Bu, result değişkeninin durumunun değişebilir olduğunu ve bu değişikliklerin Jetpack Compose tarafından algılanıp uygun şekilde işlenmesi gerektiğini belirtiyor.
 * Bu durum, uygulamanın farklı parçaları arasında güncellendiğinde, tüm yerlerde güncellenecek ve yeniden çizilecektir.
 * remember ise, bileşenin durumunun korunmasını sağlar. Böylece, kullanıcı butona bastığında bileşenin durumu sıfırlanmaz ve önceki değerlerini korur.
 * Kullanıcı her butona bastığında, result değişkeni rastgele bir sayıyla güncellenir ve bu güncelleme remember ile korunur.
 *
 * Yani, remember ve mutableStateOf kullanımı, bileşenin durumunun korunmasını ve güncellemelerin uygun şekilde işlenmesini sağlar.
 * Bu şekilde, kullanıcı her butona bastığında bileşenin doğru şekilde davranmasını sağlayabiliriz.
 */
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DiceApp() {
    DiceRollerTheme {
        DiceWithButtonAndImage()
    }
}