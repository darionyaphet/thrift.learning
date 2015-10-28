namespace java org.darion.yaphet.gen

struct Message {
  1: string first_name,
  2: string last_name, 
  3: i32  age,
  4: optional string hobby,
}


service EchoService {
  string echo(1: Message message)
}
