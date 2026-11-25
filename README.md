# Kaynak Yönetimi – Spring Boot Mikroservis ve OAuth2 Denemesi

OAuth2 yetkilendirme sunucusu, ona bağlı bir kaynak (admin) servisi, ortak yapılandırma modülü, Spring Boot Admin izleme sunucusu ve Angular arayüzünden oluşan mikroservis altyapısı denemesi. Rol/yetki kontrolünün özel anotasyonlarla yapılması gösteriliyor.

> **Not:** Bu depo 2019 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları eskidir ve bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

| Klasör | Ne yapar |
|---|---|
| `oauth2server` | Spring Security OAuth2 yetkilendirme sunucusu (port 9999). Kullanıcı, rol ve yetki varlıkları H2 bellek veritabanında; açılışta örnek rol ve kullanıcılar oluşturulur. `/user` ucu token sahibinin bilgisini döner. `src/main/resources/img` altında token alma/kullanma örneklerinin ekran görüntüleri vardır. |
| `common` | Diğer servislerin bağımlılık olarak kullandığı ortak modül: kaynak sunucusu ayarı (`@EnableResourceServer`), metod güvenliği ve `@ReadAuthorization`, `@WriteAuthorization`, `@ClientAuthorization` anotasyonları, Swagger, Hazelcast önbellek, Log4j2 ve `dev`/`stage`/`prod` profilleri. |
| `admin` | `common` üzerine kurulu kaynak servisi. Veritabanından okunan mesaj kaynakları (`/message`, çoklu dil) ve parametre CRUD (`/parameter`) uçları. |
| `springserver` | Spring Boot Admin sunucusu (port 8081); servisler buraya kaydolur. |
| `ui` | Angular 7 + Angular Material + Bootstrap arayüzü: giriş/kayıt ekranları, kullanıcı ve rol listeleri, ortak CRUD servis sınıfı. |

## Teknolojiler

- Java 8, Maven (her modülün ayrı `pom.xml` dosyası var, üst proje yok)
- Spring Boot 2.0.3 / 2.0.5, Spring Cloud Finchley.SR1 (OAuth2, Security), Spring Data JPA, H2
- Spring Boot Admin 2.0.1, Hazelcast, Springfox Swagger 2, Log4j2, Lombok
- Angular 7.2, Angular Material 7, Bootstrap 4

## Çalıştırma

1. `common` modülünü önce yerel Maven deposuna kurun: `common` klasöründe `mvn install`.
2. Sırasıyla `springserver`, `oauth2server` ve `admin` klasörlerinde `mvn spring-boot:run` çalıştırın.
3. Token almak için `oauth2server` üzerindeki `/oauth/token` adresine istemci bilgileriyle (Basic Auth) ve kullanıcı adı/şifreyle `password` grant isteği atın. İstemci kimliği `AuthorizationServerConfig`, örnek kullanıcılar `OauthApplication` içinde tanımlıdır; kendi değerlerinizi kullanın.
4. Arayüz için `ui` klasöründe `npm install` ve `npm start` çalıştırıp `http://localhost:4200` adresini açın. Angular 7 araçları eski bir Node.js sürümü ister (Node 10 dönemi).

Veritabanı H2 bellek veritabanıdır; her açılışta sıfırlanır.
