## 1. Perbaikan Masalah Kualitas Kode dan Strategi

Selama latihan, saya menemukan beberapa masalah kualitas kode yang dilaporkan oleh SonarCloud. Salah satu masalah berkaitan dengan pengelompokan dependensi di `build.gradle.kts`, di mana dependensi tidak dikelompokkan berdasarkan konfigurasinya (misalnya `implementation`, `testImplementation`, `annotationProcessor`). Saya memperbaikinya dengan menyusun ulang dependensi ke dalam kelompok yang logis.

Saya juga menangani beberapa masalah kecil terkait maintainability seperti code smell dan peringatan struktural. Strategi saya dalam menyelesaikan masalah-masalah tersebut adalah:

- Membaca deskripsi masalah di SonarCloud dengan cermat.
- Memahami apakah masalah tersebut memengaruhi kebenaran (correctness), keamanan (security), atau kemudahan pemeliharaan (maintainability).
- Menerapkan perbaikan yang terarah tanpa mengubah fungsionalitas sistem yang sudah direncanakan.

Secara keseluruhan, pendekatan saya : menemukan masalah, memahami akar penyebabnya, menerapkan perbaikan yang minimal namun tepat, lalu memverifikasi hasilnya melalui pipeline CI.

Jacoco 100% Coverage :
<img width="1919" height="469" alt="image" src="https://github.com/user-attachments/assets/9ae0fa97-829b-4883-8af9-947df5d1e611" />

---

## 2. Evaluasi Implementasi CI/CD

Implementasi saat ini telah memenuhi definisi **Continuous Integration**, tetapi belum sepenuhnya mencapai **Continuous Deployment** karena adanya kendala pada proses deployment.

**Continuous Integration** telah berhasil diterapkan karena setiap push dan pull request secara otomatis memicu workflow CI di GitHub Actions. Workflow tersebut melakukan kompilasi proyek, menjalankan seluruh rangkaian pengujian otomatis, serta melakukan analisis kode statis menggunakan SonarCloud. Hal ini memastikan bahwa masalah integrasi, kegagalan pengujian, dan masalah kualitas kode dapat terdeteksi lebih awal sebelum perubahan digabungkan ke branch utama. Quality gate otomatis juga memastikan standar kualitas minimum tetap terpenuhi.

Namun, **Continuous Deployment** tidak bisa diimplementasikan. Saya belum dapat menyelesaikan tahap deployment karena mayoritas platform PaaS atau setidaknya semua platform yang saya tau memerlukan **kartu kredit** untuk aktivasi, sementara saya belum memilikinya.

Jika dari tim asdos mengoreksi ini saya harap untuk disampaikan kepada tim dosen dapat memantau platform yang akan digunakan mata kuliah Advanced Programming karena saya rasa kepemilikan kartu kredit merupakan kewenangan mahasiswa masing-masing 🙏.  
Terimakasih
