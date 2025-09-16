# Singleton Pattern

**Definition:**  
The Singleton pattern ensures that **only one instance** of a class exists and provides a **global point of access** to it.

---

## ✅ Key Points
- Constructor is **private**
- Instance is stored as a **static field**
- Accessed through a **public static method**
- **Thread-safe** (using Double-Checked Locking in this implementation)

---

## 📝 When to Use
- Logger classes
- Configuration managers
- Database connection pools
- Cache managers

---

## 🔑 Interview Questions
Explain:
- Why you made the constructor private
- Why you used `volatile` + `synchronized` (thread-safety)
- Trade-offs (Eager vs Lazy initialization)