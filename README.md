# Reference Documentation
## Requirements
* jdk19 (linux install instructions [here](https://ubuntuhandbook.org/index.php/2022/03/install-jdk-18-ubuntu/).)
* bash/zsh - need to run with `./gradlew`

## Description
For this takehome I decided to create 3 API's in a SpingBoot env. Each API 
maps to one of the functions that needs to be completed as part of the takehome, ie.:
* [contains](#post-apirectanglescontains)
* [intersects](#post-apirectanglesintersects)
* [adjacency](#post-apirectanglesisadjacent)

### Code Structure

#### src

##### config
 - this is where the Spring AppConfig lives. I just used this to initialize a bean.

##### controller
 - this is where the API Controller live, it basically just parses API input and hands it off the the rectangle engine.

##### engine
 - this is where the biz logic lives
 - **LineComparisonEngine** is a class that does stuff with 2D Lines (using geometry formulas). The rectangle calculations can be simplified if I split a rectangle into 4 lines (between the points). Because of this, I made the Line2D class & this engine to do stuff with lines.
 - **RectangleComparisonEngine** is where the Rectangle magic happens, it does all the math that is involved for achieving what the takehome asks for.

#### Types
- this package contains a bunch of custom data types like Rectangle, Line2D, Coordinate2D that are used by the engines. They're basically just data classes / POJO's and if we did have a DB it's not too far from what we'd load our DB record into. I tried to keep these classes very simpel and bare bones so that the engine could do all the work (so if we wanted to extend this to compare variosu shapes, we can just use a diff engine).

#### src/test
Unit tests for the above classes in the same structure but under the test directory. Rectangle and line engine are pretty well tested since that's where the biz logic lives. The rest of classes are mainly happy case tests due to time constraints.

There are no integ / smoke / E2E tests due to time constraints.

## QuickStart
1. Move to the repository root
```bash
cd <path/to/repository/root>
```

2. Start the server

```bash
# this will not work if JDK19 is not installed
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

# API

## Endpoints
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
 * rectangle_2: [rectangle](#Rectangle)

**Sample Request**:
```JSON
{
    "rectangle_1": {
        "topLeft": {
            "x": 0.0,
            "y": 1.0
        },
        "topRight": {
            "x": 3.0,
            "y": 1.0
        },
        "bottomLeft": {
            "x": 0.0,
            "y": 0.0
        },
        "bottomRight": {
            "x": 3.0,
            "y": 0.0
        }
    },
    "rectangle_2": {
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
}
```
#### ResponseBody
**type**: JSON \
**body**:
* List[[coordinate](#Coordinate)]
  * this list may be empty if there is no point of intersection.

**Sample Response:**
```JSON
[
    {
        "x": 1.0,
        "y": 0.0
    },
    {
        "x": 2.0,
        "y": 0.0
    }
]
```

### POST /api/rectangles/contains
The Request Body is defined as follows:

**type**: JSON \
**body**:
* rectangle_1: [rectangle](#Rectangle)
* rectangle_2: [rectangle](#Rectangle)

**Sample Request**:
```JSON
{
    "rectangle_1": {
        "topLeft": {
            "x": 0.0,
            "y": 1.0
        },
        "topRight": {
            "x": 3.0,
            "y": 1.0
        },
        "bottomLeft": {
            "x": 0.0,
            "y": 0.0
        },
        "bottomRight": {
            "x": 3.0,
            "y": 0.0
        }
    },
    "rectangle_2": {
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
}
```
#### ResponseBody
**type**: JSON \
**body**:
* boolean (true if a or b are contained, else false)

**Sample Response:**
```JSON
true
```
### POST /api/rectangles/isAdjacent
The Request Body is defined as follows:

**type**: JSON \
**body**:
* rectangle_1: [rectangle](#Rectangle)
* rectangle_2: [rectangle](#Rectangle)

**Sample Request**:
```JSON
{
    "rectangle_1": {
        "topLeft": {
            "x": 0.0,
            "y": 1.0
        },
        "topRight": {
            "x": 3.0,
            "y": 1.0
        },
        "bottomLeft": {
            "x": 0.0,
            "y": 0.0
        },
        "bottomRight": {
            "x": 3.0,
            "y": 0.0
        }
    },
    "rectangle_2": {
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
}
```
#### ResponseBody
**type**: JSON \
**body**:
* boolean (true if a or b are contained, else false)

**Sample Response:**
```JSON
true
```

---

## Types
### Rectangle
type: JSON
body:
- topLeft: [coordinate](#Coordinate)
- topRight: [coordinate](#Coordinate)
- bottomLeft: [coordinate](#Coordinate)
- bottomLeft: [coordinate](#Coordinate)

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

### Coordinate
type: JSON
body:
- x: float
- y: float

Example:
```JSON
{
  "x": 1.1,
  "y": 1.2
}
```
