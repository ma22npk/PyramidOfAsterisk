# PyramidOfAsterisk
アスタリスクのピラミッドのコードです。
# アスタリスクのピラミッド
Javaを使って入力した数の団だけアスタリスクでピラミッドを作成する、「 **アスタリスクのピラミッド** 」プログラムを作ったメモ。

完成品はこちら

```
■SC1: 入力値「1: 続行」／「-1: 終了」
1
ピラミッドを作ります。何段のピラミッドを作りますか？
10
         *
        ***
       *****
      *******
     *********
    ***********
   *************
  ***************
 *****************
*******************
これは10段のピラミッドです


■SC1: 入力値「1: 続行」／「-1: 終了」
```


## 共通点を探す
このピラミッドがどのように作られているかを考えるために、「**ピラミッドが何段になっても変わらない共通点**」や、どういう規則で作られているかを考えるため、上記の10段のものに加え、３段で作ったピラミッドを作成して比較してみます。

```
■SC1: 入力値「1: 続行」／「-1: 終了」
1
ピラミッドを作ります。何段のピラミッドを作りますか？
3
  *
 ***
*****
これは3段のピラミッドです

■SC1: 入力値「1: 続行」／「-1: 終了」
```
ピラミッドの段数が10段でも、３段でも変わらない部分を考えてみると

- アスタリスクの数は何段になっても奇数
- 最上段は アスタリスク が必ず１個になる
- 最下段は 空白 が必ず0になる
- 一段増えるごとにアスタリスクの数は２つずつ増える
- 一段増えるごとに 空白 の数は 1つずつ減る。
- 一段に入力される空白の数は、(段数 - 1)

という部分が考えられます。

```
【３段の場合のピラミッドの場合】

  *    ← 最上段 ( "*" が必ず１個になる)
 ***   ← (一段増えるごとに 空白は1つずつ減り、アスタリスクは２つずつ増える)
*****  ← 最下段 ( " " が必ず0になる)
12345  ← 横マスの数 
```

## やりたいことを文章化
やるべきことが見えたら、それを文章化して

1. 空白の数を ( 段数 - 1 ) 個表示させる
2. その横に アスタリスクを ( 段数 * 2 - 1 )個表示させる
3. 改行する
4. １〜３の流れを段数分繰り返す ※（ただし、段数は前回のループに１つずつ足した数にする。）

これらを実現するために ループ文 を使いました。
つまり上記のリストの 1~3の処理を、段数の数だけループしてあげれば実現できそうです。
またループ内の処理も for文を使うことで効率良く書くことができそうなので、そちらの処理も 「多重for文」を使うと良さそうです。

つまり、4のfor文で、1~3の処理をくるむ形で作ることが出来ます。

## ① ②~③の処理を 段の数だけループさせるためのループ分を作る。

- n段のピラミッドを作る場合、iは 0から１段のため「 i < n 」と記述。
- ①~②の処理 を内側に入れてループさせる。

```java
for (int i = 0; i < lineCount; i++) {
	// ①~②の処理...
	....
	....
	}
```

## ② 空白の数を ( 段数 - 1 ) 個表示させる

【書き方】

【Javaでのコード】

見るとピラミッドは 余白( 以下: space ) の数が、上から１つずつ減っていってます。
space は先程の３段ピラミッドを見てみると、**「( 段数 - 1 )個出力されている」**ことが見えてきます。
上のコードで使用した 「ループを重ねるごとに一つづつ増えていく i 」を使ってやれば、1ずつ減るというわけです。


- space の初期値は 0 のため、予め1を足しておく。
- 空白 (" ")は上から一つずつ減る


```java                        
for (int space = 0; space < dan - i ; space++) {
    System.out.print(" ");
}
```

## ③ その横に アスタリスクを ( 段数 * 2 - 1 )個表示させ、改行する

【書き方】

- その横に アスタリスクを ( 段数 * 2 - 1 )個表示させる
- アスタリスクの数は何段になっても奇数
- 一段増えるごとにアスタリスクの数は２つずつ増える

【Javaでのコード】

```java
for (int j = 0; j <i * 2 - 1; j++) {
    System.out.print("*"); 
}

System.out.println();　//改行
```






[インスタンス]:https://qiita.com/takahirocook/items/ec01cdcbb440cf0d1cc4
[インスタンス化]:https://qiita.com/takahirocook/items/ec01cdcbb440cf0d1cc4
[アクセス修飾子]:https://qiita.com/takahirocook/items/e51b0b9d37d95ad587fe
[フィールド]:https://qiita.com/takahirocook/items/28df75a133049a74ece1
[フィールド変数]:https://qiita.com/takahirocook/items/28df75a133049a74ece1
[new演算子]:https://qiita.com/takahirocook/items/00f9f97592bf50831d39
[カプセル化]:https://qiita.com/takahirocook/items/e469a7c0539a0012868e
[クラス]:https://qiita.com/takahirocook/items/50cbbdca8e21539170e9
[メソッド]:https://qiita.com/takahirocook/items/5bfe43576d87a2a4006c
[mainメソッド]:https://qiita.com/takahirocook/items/f4635915337303de338c
[メソッドの呼び出し]:https://qiita.com/takahirocook/items/f4635915337303de338c
[コンストラクタ]:https://qiita.com/takahirocook/items/fa1822f2f22c3786593e
[引数]:https://qiita.com/takahirocook/items/5e5b0ba79e869f4a592e
[戻り値]:https://qiita.com/takahirocook/items/3b6fa670a1d6dd4a9386
[this]:https://qiita.com/takahirocook/items/d251ec4693c68f6b9538
[getter・setter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[setter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[getter]:https://qiita.com/takahirocook/items/27828bc8477735612021
[オブジェクト指向]:https://qiita.com/takahirocook/items/041ba7a096b71ab8ffd4
[継承]:https://qiita.com/takahirocook/items/6c84ea66a6e2ad536a37
[オーバーライド]:https://qiita.com/takahirocook/items/09dd8e5f56d6617ce45a
[オーバーロード]:https://qiita.com/takahirocook/items/b937c3c07126fe7e02a4
[this]:https://qiita.com/takahirocook/items/d251ec4693c68f6b9538
[super]:https://qiita.com/takahirocook/items/75a07131e7e791c8442c

を段数分繰り返す ※（ただし、段数は前回のループに１つずつ足した数にする。）

