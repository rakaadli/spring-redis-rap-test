https://github.com/microsoftarchive/redis/releases

untuk redis server yang cepet di windows bisa dicoba download disini ya~

lalu bisa di jalanin di InteliJ di class demoredisrapapplication klik play aja di IDE nya

setelah berhasil jalan, 
untuk test rest apinya bisa pake postman, 
hit post http://localhost:9292/product 
dan body json nya
{
"id":101,
"name" : "rakalpras",
"qty": 1,
"price": 5000
}

lalu setelah itu bisa di hit get http://localhost:9292/product 