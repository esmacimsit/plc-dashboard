# PLC Dashboard — Staj Projesi  
**Production Line Monitoring & Observability Platform**

Bu proje, **stajım kapsamında** geliştirilen bir **endüstriyel üretim hattı monitoring dashboardu**dur.  
Amaç: **PLC** tabanlı üretim hatlarının (LINE-1…n) durumlarını gerçek zamanlı izlemek, **RUN / STOP değişimlerini** takip etmek, **barkod akışını** kaydetmek ve **log/uyarı (alert) yönetimi** için temel bir zemin oluşturmaktır.

---

## ✨ Özellikler
- **Hat Durumu İzleme:** Her hattın RUN / STOP durumunu ve **son değişim zamanını** gösterir.  
- **Barkod Takibi:** Üretim hattından akan barkodların kayıt altına alınması.  
- **Log Management:** Kaynak / level / zaman bazlı olay kayıtları.  
- **Monitoring & Observability:** Basit ama genişletilebilir bir altyapı — ileride **metric, alert, incident response** eklenebilir.  
- **Modern Stack:**  
  - Backend: **Spring Boot 3.5.x (Java 17)**  
  - UI: **Thymeleaf SSR + vanilla CSS/JS**  
  - Data: **Spring Data JPA + PostgreSQL**  

---

## 🚀 Hızlı Başlangıç

### PostgreSQL (Docker)
```bash
docker run --name plcdb -e POSTGRES_USER=plcuser -e POSTGRES_PASSWORD=plcpass \
  -e POSTGRES_DB=plcdb -p 5432:5432 -d postgres:16
