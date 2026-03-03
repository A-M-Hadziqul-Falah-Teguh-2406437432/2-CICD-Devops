## SOLID Reflection

### 1) Principles yang diterapkan di projek

Saya menerapkan prinsip-prinsip SOLID berikut :

- **SRP (Single Responsibility Principle)**  
  Setiap class memiliki satu tanggung jawab utama.  
  Contoh: `ProductController` hanya menangani endpoint produk, dan `CarController` hanya menangani endpoint mobil.

- **OCP (Open/Closed Principle)**  
  Perilaku dapat diperluas tanpa banyak mengubah kode lama.  
  Contoh: saya menambahkan kontrak umum `CrudReadService<T, ID>` dan `CrudWriteService<T, ID>`, lalu `ProductService` dan `CarService` cukup meng-extend kontrak tersebut.

- **LSP (Liskov Substitution Principle)**  
  Tipe turunan harus bisa menggantikan tipe induk tanpa merusak perilaku.  
  Contoh: sebelumnya `CarController` mewarisi `ProductController`, padahal domainnya berbeda. Inheritance ini dihapus agar tidak melanggar substitusi.

- **ISP (Interface Segregation Principle)**  
  Interface besar dipecah jadi interface kecil dan spesifik.  
  Contoh: pemisahan `CrudReadService` dan `CrudWriteService` agar klien hanya bergantung pada method yang benar-benar dipakai.

- **DIP (Dependency Inversion Principle)**  
  Modul level tinggi bergantung pada abstraksi, bukan detail implementasi.  
  Contoh: controller sekarang bergantung pada `ProductService` / `CarService` (interface), bukan langsung ke class implementasi.

### 2) Advantages of applying SOLID in this project :

- **Kode lebih mudah dipahami**  
  Karena SRP, file controller lebih fokus. Saat debugging fitur mobil, saya cukup lihat `CarController`, tidak tercampur logika produk.

- **Lebih mudah dikembangkan**  
  Karena OCP + ISP, saat menambah entitas baru (misalnya `Order`), kita bisa membuat `OrderService` yang meng-extend kontrak read/write tanpa mengubah service lain.

- **Lebih aman saat refactor**  
  Karena LSP, struktur inheritance yang tidak tepat dihapus. Ini mengurangi efek samping tak terduga antar controller.

- **Lebih testable dan maintainable**  
  Karena DIP (constructor injection + interface dependency), mock dependency pada test jadi lebih jelas dan perubahan implementasi lebih terisolasi.

### 3) Disadvantages of not applying SOLID in this project:

- **Class menjadi “gemuk” dan sulit dirawat**  
  Jika SRP diabaikan, satu controller bisa menangani banyak domain sekaligus (produk + mobil), sehingga perubahan kecil berisiko merusak fitur lain.

- **Setiap fitur baru memaksa edit kode lama**  
  Jika OCP diabaikan, penambahan behavior baru sering berarti mengubah class existing terus-menerus, meningkatkan risiko regression.

- **Inheritance salah pakai menyebabkan desain rapuh**  
  Jika LSP diabaikan, seperti kasus `CarController extends ProductController`, relasi “is-a” menjadi tidak valid dan membingungkan maintainers.

- **Client dipaksa bergantung pada method yang tidak dibutuhkan**  
  Jika ISP diabaikan, interface besar membuat implementasi membawa method yang tidak relevan.

- **Tight coupling ke implementasi konkret**  
  Jika DIP diabaikan, controller tergantung langsung ke class implementasi (mis. `CarServiceImpl`), sehingga sulit ganti implementasi atau melakukan unit test yang rapi.
