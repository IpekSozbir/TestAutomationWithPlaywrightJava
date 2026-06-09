🌐 TestAutomationWithPlaywrightJava Projesi

Bu repository, **Java + Playwright** kullanılarak geliştirilmiş kapsamlı bir **modern web test otomasyonu** projesidir.
Proje; temel tarayıcı etkileşimlerinden başlayarak ileri seviye UI otomasyonu, hibrit raporlama sistemleri, ekran kaydı, dinamik bekleme stratejileri, CI/CD entegrasyonu ve profesyonel test mimarilerine kadar geniş kapsamlı otomasyon senaryoları içermektedir.

Testler; Playwright framework'ünün modern otomasyon yaklaşımını öğretmek amacıyla aşamalı şekilde yapılandırılmıştır.
Her sınıf belirli bir Playwright özelliğini veya otomasyon tekniğini derinlemesine ele alacak şekilde tasarlanmıştır.

---

# 🎯 Projenin Amacı

- Playwright framework'ünün modern kullanımını öğrenmek
- Java ile profesyonel UI test otomasyonu geliştirmek
- Dinamik locator stratejilerini uygulamak
- Wait strategies (bekleme stratejileri) mantığını kavramak
- Screenshot, video recording ve PDF üretimini öğrenmek
- Allure Report + Extent Reports hibrit raporlama yapısını uygulamak
- CI/CD süreçlerinde Playwright testlerini çalıştırmak
- Gerçek test mimarileri ve reusable yapı oluşturmak
- BaseTest yaklaşımı ile sürdürülebilir framework mantığını öğrenmek

---

# 🛠️ Kullanılan Teknolojiler ve Araçlar

| Teknoloji | Açıklama |
|----------|----------|
| **Java 17** | Test otomasyon dili |
| **Playwright 1.49.0** | Modern web otomasyon framework'ü |
| **JUnit 5** | Test runner ve assertion yapısı |
| **Allure Report** | Gelişmiş test raporlama sistemi |
| **Extent Reports** | HTML tabanlı görsel raporlama |
| **JavaFaker** | Dinamik test verisi üretimi |
| **SLF4J & Logger** | Loglama sistemi |
| **Maven** | Dependency ve build yönetimi |
| **GitHub Actions** | CI/CD otomasyon süreci |
| **IntelliJ IDEA** | Geliştirme ortamı (IDE) |

---

# 📁 Proje Yapısı

```bash
TestAutomationWithPlaywrightJava/
├── .github/
│   └── workflows/
│       └── playwright-ci.yml           # GitHub Actions CI/CD pipeline

├── src/
│   └── test/
│       └── java/

│           ├── testInputAndOutput/     # Screenshot, PDF ve video çıktıları
│           │   ├── P12.png
│           │   ├── P12_1.png
│           │   ├── P12_TestOtomasyonuFullPage.pdf
│           │   └── logo.png

│           ├── utilities/              # Yardımcı framework sınıfları
│           │   ├── BaseTest.java
│           │   └── ExtentManager.java

│           ├── C01_AutoClosure.java
│           ├── C02_ManualClosure.java
│           ├── C03_ScreenSize.java
│           ├── C04_NavigationMethods.java
│           ├── C05_ElementMethods.java
│           ├── C06_ElementMethods.java
│           ├── C07_PageCheckBox.java
│           ├── C08_PageCheckBox_Uncheck.java
│           ├── C09_PageSelect.java
│           ├── C10_TextContent_innerText_innerHTML.java
│           ├── C11_ElementBilgisiAlma_isVisible_isChecked.java
│           ├── C12_Screenshot_Pdf.java
│           ├── C13_BuiltInLocators.java
│           ├── C14_OtherLocators.java
│           ├── C15_PageAssertions.java
│           ├── C16_LocatorAssertions.java
│           ├── C17_Iframe.java
│           ├── C18_Actions.java
│           ├── C19_DragAndDrop.java
│           ├── C20_Dropdown.java
│           ├── C21_BaseTestKullanimi.java
│           ├── C22_BaseTestKullanimi_ExtentReport.java
│           ├── C23_BaseTestKullanimi_AllureReport.java
│           ├── C24_SingleFileUpload.java
│           ├── C25_MultipleFileUpload.java
│           ├── C26_MultipleWindow.java
│           ├── C27_ScreenRecord.java
│           ├── C28_ScreenRecord_AllureReportV2.java
│           ├── C29_AutomationExerciseSignUp.java
│           ├── C30_AutomationExerciseSignUp_AllureReportV2.java
│           ├── C31_Scroll_AllureReportV1.java
│           ├── C32_Scroll_AllureReportV2.java
│           ├── C33_WaitStrategies_AllureReportV1.java
│           ├── C34_WaitStrategies_AllureReportV2.java
│           └── C35_LocatorMasterNotes.java

├── allure-results/
├── pom.xml
├── .gitignore
└── README.md
```

---

# 📂 Müfredat ve Sınıf Yapısı (C01 - C35)

Proje, 35 farklı sınıfta Playwright otomasyonunun kritik konularını kapsamaktadır:

| Seviye | Konular | Örnek Sınıflar |
|----------|----------|----------|
| **Temel UI** | Browser yönetimi, navigation, auto/manual closure | C01 - C04 |
| **Element İşlemleri** | Locator stratejileri, assertions, dropdown, checkbox | C05 - C20 |
| **İleri Seviye UI** | Iframe, multiple window, drag & drop, upload | C17 - C26 |
| **Raporlama & Medya** | Allure, Extent Report, screenshot, video recording | C22 - C32 |
| **Framework Stratejileri** | Wait strategies, BaseTest yapısı, scroll teknikleri | C31 - C35 |

---

# 🎯 Kapsanan Otomasyon Konuları

## 🗓️ Temel Seviye Etkileşimler

| Konu | Açıklama |
|----------|----------|
| Navigation | Sayfa geçişleri, refresh, back-forward işlemleri |
| Locators | CSS, XPath ve Playwright built-in locator kullanımları |
| Assertions | Page ve Locator doğrulamaları |
| Element Actions | Click, fill, hover, select işlemleri |

---

## 🗓️ İleri Seviye UI İşlemleri

| Konu | Açıklama |
|----------|----------|
| Iframe & Windows | Çoklu sekme ve iframe yönetimi |
| Actions | Drag & Drop, keyboard ve mouse aksiyonları |
| File Operations | Tekli/çoklu dosya yükleme işlemleri |
| Wait Strategies | Auto-waiting, explicit wait, dynamic waits |
| Scroll Operations | Sayfa scroll stratejileri |

---

## 🗓️ Raporlama ve Medya Yönetimi

| Konu | Açıklama |
|----------|----------|
| Allure Report | Modern step-based raporlama |
| Extent Reports | HTML dashboard raporları |
| Screen Recording | Test video kayıt sistemi |
| Screenshot | Full-page ve element screenshot işlemleri |
| PDF Generation | Sayfa çıktılarının PDF olarak alınması |

---

# 🏗️ Mimari ve Evrimsel Gelişim (Evolutionary Design)

Bu projeyi farklılaştıran temel noktalardan biri; framework mimarisinin zaman içinde evrimsel olarak geliştirilmiş olmasıdır.

## 1. BaseTest Stratejisi

### V1 (Başlangıç Yaklaşımı)
- Toolkit ile ekran boyutu yönetimi
- Temel browser launch işlemleri
- Basit setup/teardown yapısı

### V2 (Profesyonel Yaklaşım)
- BrowserContext izolasyonu
- `--start-maximized` desteği
- `setViewportSize(null)` kullanımı
- Daha stabil ekran ölçekleme sistemi
