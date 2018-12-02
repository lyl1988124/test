namespace java com.lyl.thrift
service HelloService{
    string helloString(1:MyParam para);
}

service HellService{
    string helloString(1:MyParam para);
}

struct MyParam
{
    1:string para,
    2:bool para2,
    3:byte para3,
    4:i16 para4,
    5:i32 para5,
    6:i64 para6,
    7:double para7,
    8:string para8
}