Proje Adı: Dişçi Kliniği Randevu Sistemi RESTful Web API
___________________________________________________________________________________
Proje Sahibi: Hakan Cem GERÇEK.
___________________________________________________________________________________
Proje Başlama Tarihi: 3.09.2025
___________________________________________________________________________________
Proje Bitirme Tarihi: 6.09.2025
___________________________________________________________________________________
Yapı: RESTFul Web API.
___________________________________________________________________________________
Dil: Java 24
___________________________________________________________________________________
Teknolojiler: 
  + Spring Framework 6 / Spring Boot 3.5.5, 
  + Maven
___________________________________________________________________________________
Amaç: Dişçiden randevu almak isteyen bir hastanın dişçinin müsaitlik durumuna, tarihine ve saatine göre randevu oluşturabildiği, randevusunun güncellenebildiği, sisteme yeni dişçi eklenip güncellenebildiği, müsaitlik durumunun ayarlanabildiği ve hastanın geçmiş tedavi durumunun görüntülenebildiği gerçek bir randevu mantığıyla tasarlanmış web api.
___________________________________________________________________________________
Dependency'ler: 
  + Spring Web
  + Spring Data JPA
  + Lombok
  + Validations
  + Spring DevTools
  + MySQL
  + H2
___________________________________________________________________________________
İçerik: İlk olarak gerekli validasyon mantığına uyarak entity'leri tanımladım, tanımladığım entity'ler için gerekli dto'ları ve enum'ları yazdım. Entity'den dto'ya ve dto'dan entity'ye çevirmeler için manuel mapper yapısnı kullandım. mapStruct yapısını kullanmamamın sebebi şimdilik entity'lerdeki field sayısının değişmeyecek olması. Exception'ları da oluşturduktan sonra MVC katmanı için repository, service ve controller katmanlarını yazdım. Böylece API'yı tamamlamış oldum. Henüz swagger, loglama, pagination veya security eklemedim. İlerleyen zamanlarda versiyon güncellemesi için bunları kullanabilirim.
___________________________________________________________________________________
Database konfigürasyonu :
  POSTMAN üzerinden gerekli testleri yaptığım için database bağlantısı kullanmadım. Diğer projelerimde zaten kullandığım için gerek duymadım. İhtiyaç halinde application.properties dosyasını gerekli şekilde database için güncelleyebilirim.
___________________________________________________________________________________
+ Test için gerekli end pointler ve JSON verileri (Postman):

Patient Ekle -> POSThttp://localhost:8080/api/patients/create

```
{
  "firstName": "Ahmet",
  "lastName": "Yılmaz",
  "dateOfBirth": "1990-05-15",
  "email": "ahmetyilmaz@example.com",
  "phone": "5551234567"
}
```

Patient Güncelle -> PUThttp://localhost:8080/api/patients
```
{
  "id": "1",
  "firstName": "Ayşe",
  "lastName": "Kaya",
  "dateOfBirth": "1976-02-15",
  "email": "ahmetyilmaz@example.com",
  "phone": "5551234567"
}
```

Patient Görüntüle -> GEThttp://localhost:8080/api/patients/1

Limited Patient Görüntüle -> GEThttp://localhost:8080/api/patients/limited

Full Patient Görüntüle -> GEThttp://localhost:8080/api/patients/full

Patient Sil -> DELETEhttp://localhost:8080/api/patients/delete/1

Dişçi Ekle -> POSThttp://localhost:8080/api/dentists/create
```
{
    "dentistFirstName":"Kadir",
    "dentistLastName":"Kıymet",
    "dentistEmail":"kadir@example.com",
    "dentistPhone":"5553330011"
}
```

Dişçi Güncelle -> PUThttp://localhost:8080/api/dentists
```
{
    "id":"1",
    "dentistFirstName":"Selma",
    "dentistLastName":"Kıymet",
    "dentistEmail":"selma@example.com",
    "dentistPhone":"5553330012"
}
```

Dişçi Görüntüle -> GEThttp://localhost:8080/api/dentists/1

Limited Dişçi Görüntüle -> GEThttp://localhost:8080/api/dentists/limited

Dişçi Sil -> DELETEhttp://localhost:8080/api/dentists/delete/1

Randevu Ekle -> POSThttp://localhost:8080/api/appointments/create
```
{
    "appointmentDate": "2025-11-11",
    "appointmentStatus": "COMPLETED",
    "patientId": 1,
    "dentistId": 1
}
```

Randevu Güncelle -> PUThttp://localhost:8080/api/appointments
```
{
    "id":1,
    "appointmentDate": "2027-11-11",
    "appointmentStatus": "COMPLETED",
    "patientId": 1,
    "dentistId": 1
}
```

Randevu Görüntüle -> GEThttp://localhost:8080/api/appointments/1

Tarih ve Dişçiye GöreRandevu Görüntüle -> GET http://localhost:8080/api/appointments/by-date-and-dentist?appointmentDate=2025-11-11&dentistId=1

Randevu Sil -> DELETEhttp://localhost:8080/api/appointments/delete/1

Tedavi Geçmişi Ekle -> POSThttp://localhost:8080/api/medical-histories/create
```
{
    "patientId":1,
    "dentistId":1,
    "pastMedicalDate": "2023-11-11",
    "diagnosisName":"Tedavi1",
    "treatmentName":"Yöntem1",
    "note":"not1"
}
```

Tedavi Geçmişi Güncelle -> POSThttp://localhost:8080/api/medical-histories
```
{
    "id":1,
    "patientId":1,
    "dentistId":1,
    "pastMedicalDate": "2023-11-11",
    "diagnosisName":"Tedavi2",
    "treatmentName":"Yöntem2",
    "note":"not2"
}
```

Tedavi Geçmişi Görüntüle -> GEThttp://localhost:8080/api/medical-histories/1

Hastaya Göre Tedavi Geçmişi Görüntüle -> GEThttp://localhost:8080/api/medical-histories/by-patient/1

Tedavi Geçmişini Sil -> DELETEhttp://localhost:8080/api/medical-histories/delete/1

Müsaitlik Durumu Ekle -> POSThttp://localhost:8080/api/availabilities/create
```
{
    "availabilityDate":"2027-11-11",
    "startTime": "14:30:45",
    "endTime": "17:30:00",
    "availabilityStatus":"AVAILABLE",
    "dentistId":1
}
```

Müsaitlik Durumu Güncelle -> PUThttp://localhost:8080/api/availabilities/update
```
{
    "id":1,
    "availabilityDate":"2027-11-11",
    "startTime": "20:30:45",
    "endTime": "21:30:00",
    "availabilityStatus":"AVAILABLE",
    "dentistId":1
}
```

Müsaitlik Durumu Güncelle -> GEThttp://localhost:8080/api/availabilities/1
______________________________________________________________________________________________________________________________________________________________________
iletişim: hakancg05@gmail.com

Dişçiye Göre Müsaitlik Durumu Güncelle -> GEThttp://localhost:8080/api/availabilities/dentist/1/availabilityDate/2027-11-11

Müsaitlik Durumu Sil -> DELETEhttp://localhost:8080/api/availabilities/delete/1
