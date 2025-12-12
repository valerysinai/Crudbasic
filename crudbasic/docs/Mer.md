# Modelo Entidad-Relación (MER)

## Base de Datos: CursosOnlineDB

### Entidades principales:

#### 1. Instructores
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdInstructor   | INT (PK)     | Clave primaria             |
| IdUsuario      | INT          | Referencia al usuario      |
| Biografia      | VARCHAR(500) | Biografía del instructor   |

#### 2. Cursos
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdCurso        | INT (PK)     | Clave primaria             |
| IdInstructor   | INT (FK)     | Clave foránea → Instructores |
| Titulo         | VARCHAR(150) | Título del curso           |
| Descripcion    | VARCHAR(500) | Descripción                |
| Precio         | DECIMAL      | Precio del curso           |
| FechaCreacion  | DATETIME     | Fecha de creación          |

#### 3. Lecciones
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdLeccion      | INT (PK)     | Clave primaria             |
| IdCurso        | INT (FK)     | Clave foránea → Cursos     |
| Titulo         | VARCHAR(150) | Título de la lección       |
| Contenido      | TEXT         | Contenido de la lección    |
| DuracionMin    | INT          | Duración en minutos        |

### Relaciones:
```
Instructores (1) ──────── (N) Cursos
                             │
                             │
                             │ (1)
                             │
                             │
                             ▼
                            (N)
                         Lecciones
```

**Explicación:**
- Un **Instructor** puede tener **MUCHOS** Cursos (1:N)
- Un **Curso** puede tener **MUCHAS** Lecciones (1:N)

### Diagrama ASCII:
```
┌─────────────────┐
│  Instructores   │
│─────────────────│
│ IdInstructor PK │
│ IdUsuario       │
│ Biografia       │
└────────┬────────┘
         │
         │ 1
         │
         │ N
         ▼
┌─────────────────┐
│     Cursos      │
│─────────────────│
│ IdCurso PK      │
│ IdInstructor FK │
│ Titulo          │
│ Descripcion     │
│ Precio          │
│ FechaCreacion   │
└────────┬────────┘
         │
         │ 1
         │
         │ N
         ▼
┌─────────────────┐
│   Lecciones     │
│─────────────────│
│ IdLeccion PK    │
│ IdCurso FK      │
│ Titulo          │
│ Contenido       │
│ DuracionMin     │
└─────────────────┘
```
```

**4️⃣ Guarda el archivo**

---

### **PASO 5: Crear README.md**

#### **¿Qué es README.md?**
Es la **portada** de tu proyecto en GitHub. Es lo primero que la gente ve.

#### **Cómo crearlo:**

**1️⃣ Crea un archivo `README.md` en la RAÍZ del proyecto:**
```
crudbasic/
├── README.md      ← AQUÍ
├── docs/
├── src/
└── pom.xml"

# Modelo Entidad-Relación (MER)

## Base de Datos: CursosOnlineDB

### Entidades principales:

#### 1. Instructores
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdInstructor   | INT (PK)     | Clave primaria             |
| IdUsuario      | INT          | Referencia al usuario      |
| Biografia      | VARCHAR(500) | Biografía del instructor   |

#### 2. Cursos
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdCurso        | INT (PK)     | Clave primaria             |
| IdInstructor   | INT (FK)     | Clave foránea → Instructores |
| Titulo         | VARCHAR(150) | Título del curso           |
| Descripcion    | VARCHAR(500) | Descripción                |
| Precio         | DECIMAL      | Precio del curso           |
| FechaCreacion  | DATETIME     | Fecha de creación          |

#### 3. Lecciones
| Campo          | Tipo         | Descripción                |
|----------------|--------------|----------------------------|
| IdLeccion      | INT (PK)     | Clave primaria             |
| IdCurso        | INT (FK)     | Clave foránea → Cursos     |
| Titulo         | VARCHAR(150) | Título de la lección       |
| Contenido      | TEXT         | Contenido de la lección    |
| DuracionMin    | INT          | Duración en minutos        |

### Relaciones:
```
Instructores (1) ──────── (N) Cursos
                             │
                             │ (1)
                             │
                             ▼
                            (N)
                         Lecciones
```

**Explicación:**
- Un **Instructor** puede tener **MUCHOS** Cursos (1:N)
- Un **Curso** puede tener **MUCHAS** Lecciones (1:N)

### Diagrama ASCII:
```
┌─────────────────┐
│  Instructores   │
│─────────────────│
│ IdInstructor PK │
│ IdUsuario       │
│ Biografia       │
└────────┬────────┘
         │
         │ 1
         │
         │ N
         ▼
┌─────────────────┐
│     Cursos      │
│─────────────────│
│ IdCurso PK      │
│ IdInstructor FK │
│ Titulo          │
│ Descripcion     │
│ Precio          │
│ FechaCreacion   │
└────────┬────────┘
         │
         │ 1
         │
         │ N
         ▼
┌─────────────────┐
│   Lecciones     │
│─────────────────│
│ IdLeccion PK    │
│ IdCurso FK      │
│ Titulo          │
│ Contenido       │
│ DuracionMin     │
└─────────────────┘
```