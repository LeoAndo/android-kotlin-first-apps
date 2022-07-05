struct Person {
    let name:String
}

// 15 コレクション変換操作: map関数
let list = ["Yamada", "Tanaka"]
let result = list.map{ $0 + " San"}
print(result)

let result2: [Person] = list.map{ name in Person(name: name)}
print(result2)



