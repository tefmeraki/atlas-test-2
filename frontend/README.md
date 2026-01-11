# Frontend (Iteración 4)

Frontend **muy simple** (HTML + JS) para probar el backend.

## Cómo usar

1) Arranca el backend (Spring Boot) en `http://localhost:8080`.
2) Abre `index.html` en el navegador.

> Si tu navegador bloquea `fetch` por abrir el HTML con `file://`, usa un servidor estático:

```bash
# opción A (python)
python -m http.server 5173

# opción B (node)
npx serve -l 5173
```

Y luego abre:
- `http://localhost:5173/frontend/index.html`
