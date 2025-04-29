
Bu loyiha Android ilovalarida GitHub API bilan ishlash va Volley yordamida tarmoq ma’lumotlarini olish bo‘yicha misol sifatida ishlab chiqilgan. Kod aniq va optimallashtirilgan bo‘lib, Android uchun RecyclerView va WebView texnologiyalaridan foydalanadi.

Agar loyiha sizga yoqsa ⭐ Star bosing va o‘z fikrlaringizni bildirishingiz mumkin! 😊

# 🚀 Volley & Network Check (GitHub API Followers)

Bu loyiha **GitHub API** orqali foydalanuvchilar ro‘yxatini olib keladi va **RecyclerView** yordamida ko‘rsatadi. 

## 🛠 Foydalanilgan texnologiyalar:

- **Volley** → Internetdan ma’lumot olish uchun
- 
- **Glide** → Avatar URL’ni `CircleImageView`ga yuklash uchun
- 
- **CircleImageView** → Yumaloq UI ImageView uchun
- 
- **WebView** → Bosilgan `item` uchun GitHub profil sahifasini ochish
- 
- **RecyclerView** → Foydalanuvchilar ro‘yxatini chiqarish
- 
- **NetworkUtils** → Internet mavjudligini tekshirish

---

## 📸 Skrinshotlar:
<p align="center">
    <img src="https://github.com/user-attachments/assets/234140df-f918-4eac-b40a-bfb83980f46b" width="45%">
    <img src="https://github.com/user-attachments/assets/6295e08c-f07a-4ef8-94ee-9835814d7c8d" width="45%">
</p>
---

## 🔧 O‘rnatish:
1. **Loyihani klonlash**:
   ```sh
   git clone https://github.com/username/VolleyNetworkCheck.git
   
   cd VolleyNetworkCheck

   dependencies {
    implementation("com.android.volley:volley:1.2.1")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("de.hdodenhof:circleimageview:3.1.0")
}

