# Reference Documentation

## Assumptions
<>

## QuickStart
1. Move to the repository root
```bash
cd <path/to/repository/root>
```

2. Start the server

```bash
./gradlew bootRun
```

3. Test that the server is up
```bash
curl localhost:8080
# you should see this as a response
> "Greetings from Spring Boot!"
```

### Running Unit Tests
1. Move to the repository root
```bash
cd <path/to/repository/root>
```

2. Run the unit tests using the gradle wrapper.
```bash
./gradlew test
```

## API

### GET /
This is the test API, it should always return
```bash
"Greetings from Spring Boot!"
```

### POST /api/rectangles/intersects
#### Description
An API that determines if two rectangles intersect, if they do it'l return
the points of intersection, if they dont - it'l return an empty list.

#### Request Body
The Request Body is defined as follows:

**type**: JSON \
**body**: 
 * rectangle_1: [rectangle](#Rectangle)
##### Example

### POST /api/rectangles/contains

### POST /api/rectangles/isAdjacent

## Types
### Rectangle
type: JSON
body:
- topLeft:
  - x: float
  - y: float
- topRight:
    - x: float
    - y: float
- bottomLeft:
    - x: float
    - y: float
- bottomLeft:
    - x: float
    - y: float

Example:
```JSON
{
  "topLeft": {
    "x": 1.0,
    "y": 0.5
  },
  "topRight": {
    "x": 2.0,
    "y": 0.5
  },
  "bottomLeft": {
    "x": 1.0,
    "y": -0.5
  },
  "bottomRight": {
    "x": 2.0,
    "y": -0.5
  }
}

```