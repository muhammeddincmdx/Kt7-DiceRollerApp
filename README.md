## Final View
![resim](https://github.com/muhammeddincmdx/Kt7-DiceRollerApp/assets/54439858/8bca481d-8b9d-4c53-aa0f-62c5eae39c25)



### Notes.
````
`@Composable
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
````
