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
İçerik: İlk olarak gerekli validasyon mantığına uyarak entity'leri tanımladım, tanımladığım entity'ler için gerekli dto'ları ve enum'ları yazdım. Entity'den dto'ya ve dto'dan entity'ye çevirmeler için manuel mapper yapısnı kullandım. mapStruct yapısını kullanmamamın sebebi şimdilik entity'lerdeki field sayısının değişmeyecek olması. Exception'ları da oluşturduktan sonra MVC katmanı için repository, service ve controller katmanlarını yazdım. Böylece API'yı tamamlamış oldum. Henüz swagger, loggin, pagination veya security eklemedim. İlerleyen zamanlarda versiyon güncellemesi için bunları kullanabilirim.
___________________________________________________________________________________
