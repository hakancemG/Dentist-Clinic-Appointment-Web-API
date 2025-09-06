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

Patient Ekle --> POST .../api/patients/create

```
{
  "firstName": "Ahmet",
  "lastName": "Yılmaz",
  "dateOfBirth": "1990-05-15",
  "email": "ahmetyilmaz@example.com",
  "phone": "5551234567"
}
```

Patient Güncelle --> PUT .../api/patients

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

Patient Görüntüle --> GET .../api/patients/1

Limited Patient Görüntüle --> GET .../api/patients/limited

Full Patient Görüntüle --> GET .../api/patients/full

Patient Sil --> DELETE .../api/patients/delete/1

Dişçi Ekle --> POST .../api/dentists/create
```
{
    "dentistFirstName":"Kadir",
    "dentistLastName":"Kıymet",
    "dentistEmail":"kadir@example.com",
    "dentistPhone":"5553330011"
}
```

Dişçi Güncelle -> PUT .../api/dentists
```
{
    "id":"1",
    "dentistFirstName":"Selma",
    "dentistLastName":"Kıymet",
    "dentistEmail":"selma@example.com",
    "dentistPhone":"5553330012"
}
```

Dişçi Görüntüle -> GET .../api/dentists/1

Limited Dişçi Görüntüle -> GET .../api/dentists/limited

Dişçi Sil -> DELETE .../api/dentists/delete/1

Randevu Ekle -> POST .../api/appointments/create
```
{
    "appointmentDate": "2025-11-11",
    "appointmentStatus": "COMPLETED",
    "patientId": 1,
    "dentistId": 1
}
```

Randevu Güncelle -> PUT .../api/appointments
```
{
    "id":1,
    "appointmentDate": "2027-11-11",
    "appointmentStatus": "COMPLETED",
    "patientId": 1,
    "dentistId": 1
}
```

Randevu Görüntüle -> GET .../api/appointments/1

Tarih ve Dişçiye GöreRandevu Görüntüle -> GET .../api/appointments/by-date-and-dentist?appointmentDate=2025-11-11&dentistId=1

Randevu Sil -> DELETE .../api/appointments/delete/1

Tedavi Geçmişi Ekle -> POST .../api/medical-histories/create
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

Tedavi Geçmişi Güncelle -> POST .../api/medical-histories
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

Tedavi Geçmişi Görüntüle -> GET .../api/medical-histories/1

Hastaya Göre Tedavi Geçmişi Görüntüle -> GET .../api/medical-histories/by-patient/1

Tedavi Geçmişini Sil -> DELETE .../api/medical-histories/delete/1

Müsaitlik Durumu Ekle -> POST .../api/availabilities/create
```
{
    "availabilityDate":"2027-11-11",
    "startTime": "14:30:45",
    "endTime": "17:30:00",
    "availabilityStatus":"AVAILABLE",
    "dentistId":1
}
```

Müsaitlik Durumu Güncelle -> PUT .../api/availabilities/update
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

Müsaitlik Durumu Güncelle -> GET .../api/availabilities/1

Dişçiye Göre Müsaitlik Durumu Güncelle -> GET .../api/availabilities/dentist/1/availabilityDate/2027-11-11

Müsaitlik Durumu Sil -> DELETE .../api/availabilities/delete/1
______________________________________________________________________________________________________________________________________________________________________
iletişim: hakancg05@gmail.com
