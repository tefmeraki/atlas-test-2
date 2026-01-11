# 🧪 ATLAS · Extra · Postman + Verificación del MVP

---

## 🎯 Objetivo de este extra

Este extra sirve para **demostrar y verificar el MVP en limpio**, justo antes de entrar en:

* **Fase 4 (Validación y pruebas)**
* **Fase 5 (Documentación y defensa)**

Concretamente permite:

* Tener una **demo reproducible** (no improvisada).
* Probar rápidamente que el backend **está levantado y responde**.
* Mostrar al tribunal **evidencias claras de funcionamiento**.
* Detectar errores típicos antes de la defensa.

👉 **No añade funcionalidad nueva**. Solo consolida y valida lo ya hecho.

---

## 📦 Qué incluye este extra

Este paquete incluye cuatro elementos:

1. **Colección Postman**

   * Para ejecutar y mostrar el MVP paso a paso.

2. **Environment Postman**

   * Para configurar fácilmente la URL base (`localhost`, puerto, etc.).

3. **Script de verificación automática (PowerShell)**

   * Pensado para Windows.

4. **Script de verificación automática (Bash)**

   * Para macOS, Linux o Git Bash en Windows.

Todos ellos apuntan a los **endpoints reales del MVP**.

---

## ⚙️ Requisitos previos

### Software necesario

* Java + Maven (si el backend es Spring Boot).
* Base de datos configurada (si aplica).
* Postman instalado (recomendado para la demo).
* Para scripts:

  * **Windows**: PowerShell 5 o superior.
  * **macOS / Linux**: terminal Bash.
  * **Windows (alternativa)**: Git Bash o WSL.

---

## ▶️ Paso 1 · Arrancar el backend

Antes de usar Postman o los scripts, el backend **debe estar levantado**.

### Opción habitual (Spring Boot + Maven)

```bash
mvn spring-boot:run
```

O desde el IDE (IntelliJ IDEA):

* Ejecutar la configuración de la aplicación Spring Boot.

---

## 🔍 Paso 2 · Comprobación rápida manual

Abre el navegador y comprueba uno de estos endpoints (según tu proyecto):

* `http://localhost:8080/api/health`
* `http://localhost:8080/actuator/health`

Si responde correctamente, el backend está listo.

---

## 📬 Paso 3 · Uso de Postman (demo y pruebas)

### 3.1 Importar la colección

1. Abre **Postman**.
2. Pulsa **Import**.
3. Selecciona el archivo:

   * `ATLAS_Postman_Collection.json`

---

### 3.2 Importar el Environment

1. En Postman, vuelve a **Import**.
2. Selecciona:

   * `ATLAS_Postman_Environment.json`
3. Activa ese environment (arriba a la derecha).

---

### 3.3 Configurar variables del Environment

Revisa y ajusta:

* `baseUrl` → normalmente `http://localhost:8080`

Guarda los cambios.

---

### 3.4 Ejecutar la demo en Postman

Ejecuta las peticiones **en orden**:

1. Health / Ping
2. Crear entidad principal (POST)
3. Listar entidades (GET)
4. Flujo principal del MVP (reserva / inscripción / similar)

👉 Si algún endpoint devuelve error:

* revisa logs del backend,
* revisa la ruta (`@RequestMapping`),
* revisa la BD.

---

## 🤖 Paso 4 · Verificación automática (scripts)

Los scripts permiten validar el MVP **sin Postman**, en pocos segundos.

---

### 4.1 Windows · PowerShell

1. Abre PowerShell en la carpeta del script.
2. Ejecuta:

```powershell
.\verify_mvp.ps1
```

Si PowerShell bloquea la ejecución:

```powershell
Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass
```

Y vuelve a ejecutar el script.

---

### 4.2 macOS / Linux / Git Bash

1. Abre terminal en la carpeta del script.
2. Da permisos de ejecución:

```bash
chmod +x verify_mvp.sh
```

3. Ejecuta:

```bash
./verify_mvp.sh
```

---

### 4.3 Cambiar puerto o URL

Si tu backend no usa `localhost:8080`, ajusta:

* el archivo del script (`BASE_URL`), o
* la variable del Environment en Postman.

---

## ✅ Cómo interpretar el resultado

### Caso correcto

* El script muestra respuestas OK.
* Health responde.
* Los endpoints clave devuelven 200 / 201.

👉 El MVP está listo para demo.

---

### Casos de error típicos

* **Connection refused** → backend no levantado o puerto incorrecto.
* **404 Not Found** → ruta incorrecta.
* **500 Internal Server Error** → error en backend o BD.
* **401 / 403** → seguridad activada.

Solución:

1. Revisar logs del backend.
2. Ajustar rutas o configuración.
3. Volver a ejecutar.

---

## 🎤 Checklist rápido para defensa

Antes del tribunal:

* Backend arranca sin errores.
* Script de verificación pasa correctamente.
* Postman muestra:

  * 1 POST
  * 1 GET
  * 1 flujo principal del MVP

Y puedes explicar:

1. Modelo de datos.
2. Flujo del MVP.
3. Decisiones técnicas clave.

---

## 🧠 Nota ATLAS

Este extra **no es obligatorio**, pero:

* reduce riesgos el día de la defensa,
* mejora mucho la percepción de calidad,
* demuestra control real del proyecto.

👉 Una vez completado este extra, el proyecto está listo para:

* **Fase 4 · Validación y pruebas**
* **Fase 5 · Documentación y defensa**

---

## 🔚 Cierre

Si puedes ejecutar el script en limpio y repetir la demo sin improvisar,

**el MVP está realmente terminado.**
