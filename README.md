# PLC Dashboard — Internship Project  
**Production Line Monitoring & Observability Platform**

This project was developed as part of my **internship**.  
It is an **industrial production line monitoring dashboard** built to track **PLC**-based lines (LINE-1…n), observe their **RUN/STOP state**, capture **barcode flows**, and manage **basic logs/alerts** for monitoring and observability.

---

## ✨ Features
- **Line Status Monitoring:** Displays RUN / STOP state and the **last change timestamp**.  
- **Barcode Tracking:** Records barcodes flowing through each production line.  
- **Log Management:** Source / level / timestamp-based log records.  
- **Monitoring & Observability:** Simple but extensible foundation — future support for **metrics, alerts, incident response**.  
- **Tech Stack:**  
  - Backend: **Spring Boot 3.5.x (Java 17)**  
  - UI: **Thymeleaf SSR + vanilla CSS/JS**  
  - Data: **Spring Data JPA + PostgreSQL**  

---

## 🚀 Quick Start

```bash
# 1) Run PostgreSQL
docker run --name plcdb -e POSTGRES_USER=plcuser -e POSTGRES_PASSWORD=plcpass \
  -e POSTGRES_DB=plcdb -p 5432:5432 -d postgres:16

# 2) Clone and run the app
git clone https://github.com/esmacimsit/plc-dashboard.git
cd plc-dashboard
./mvnw spring-boot:run

# 3) Open in browser
http://localhost:8080
```

---

## ⚙️ Configuration (application.properties)
```bash
server.port=8080

spring.datasource.url=jdbc:postgresql://localhost:5432/plcdb
spring.datasource.username=plcuser
spring.datasource.password=plcpass

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.thymeleaf.cache=false
```

---

## 🗄 Data Model
plc_info → PLC device information
line_info → Line name, RUN/STOP status, last updated timestamp
barcode_data → Barcode flow data per line
plc_logs → Logs (source, level, message, timestamp)

--- 

## 🏗 Architecture
[Thymeleaf UI] → [Controller] → [Service] → [JPA Repository] → [PostgreSQL]
Layered structure: Controller → Service → Repository
Future direction: REST API, metrics/alerts, role-based authentication

---

## 📈 Roadmap
 Alert rules (e.g., STOP longer than X minutes → trigger warning)
 Metrics: OEE, MTBF, MTTR, throughput
 REST API (Swagger/OpenAPI)
 CI/CD pipeline (GitHub Actions + Docker)
 Docker Compose for one-command demo

---

## 🔑 Keywords
PLC monitoring, production line observability, manufacturing dashboard, barcode tracking,
real-time status monitoring, incident response, OEE, MTBF, MTTR, downtime analysis,
Spring Boot, Java 17, Thymeleaf, PostgreSQL, JPA, internship project

