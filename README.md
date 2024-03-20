## Basic Api Crud

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
[![Licence](https://img.shields.io/github/license/Ileriayo/markdown-badges?style=for-the-badge)](./LICENSE)

### PT-BR
Esse projeto é uma API básica criada utilizando <b>Java</b> and <b>Java Spring</b>.

### EN-US
This project is a Basic Api created using <b>Java</b> and <b>Java Spring</b>.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone the repository:

```bash
git clone git@github.com:PedroH183/ApiSpring.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints
The API provides the following endpoints:

**Create Product**
```markdown
POST /product/add - Create a new product 
```

**BODY**
```json
{
    "name" : "Lâmpada",
    "price_in_cents" : 2020
}
```
<hr/>

**Update Product**
```markdown
PUT /product/edit/<ID_PRODUCT> - Update a product
```

**BODY**
```json
{
    "name" : "Mesa",
    "price_in_cents" : 2020
}
```

<hr/>

**Get All Products**
```markdown
GET /product/All 
```

**BODY**
```json
[
{
  "id": "a7d1b143-9abc-49ef-8ed5-d51c31c4f0a0",
  "name": "Lâmpada",
  "price_in_cents": 2020
}
...
]
```

**Delete a Product**
```markdown
DELETE /product/delete/<ID_PRODUCT> 
```

## Database

This project follows some JPA conventions to connect with the database. Configure your connection in `src/main/resources/application.properties.`

**Spring Resources to Connect your database**
```markdown
spring.datasource.url=jdbc:postgresql://localhost:5432/products_db
spring.datasource.username=postgres
spring.datasource.password=1234
```

**Tabel Product**
```markdown
CREATE TABLE product(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price_in_cents INT NOT NULL
);
```

