Iterator pattern -> pull (consumer pulls from iterator impl) => Collection streams

Observer pattern -> push (subject push to observer) => Reactive streams

---

Reactive Programming -> Assembly Line Analogy

Reactive in no way mean async, it is agnostic and can be sync, depends on impl

It is Declarative - assign the workers(lambda - analogy) and let the belt(publisher - analogy) push the event and run
them

---

forEach = subscribe

toStream = blocking operation (flux)

block = blocking operation (mono)

subscribe = Always required, belt start switch from analogy (trigger)

---
Defined by number of items it intends to send

- Flux - async seq of 0 or n items
- Mono - async seq of 0 or 1 item -- Mono can be of list as well, any type

--- 

Event types

- Item
- Terminal event -- Complete or failure

In Mono, Once an item is emitted we get completed immediately

- API mostly work with Mono

Flux Can be infinite

---

Operators return Mono/Flux similar to collection streams

(The operators are just applied on Mono/Flux, if returned then they will be executed in calling function, only when the
event is fired)

- filter = filter
- map = map
- take
- log
- defaultIfEmpty
- flatMap = flatMap
- distinct
- distinctUntilChanged

---

Error event from a flux is a terminal event only per defaults,

But if consumer still wants to consume, it can become a non-terminal event and further events will be processed, so it
depends on consumer

*Consider it with try catch analogy, even after catching you can do as required*

- onErrorContinue - continue on error
- onErrorResume - fallback seq to replace original seq
- doFinally - runs on terminal event either complete or error

---

count & collectList operator - Flux to Mono

**buffer operator** - holds n events and resolves on nth event as single event of new flux, for flux of integer, the
buffer operator would return flux of list of n integers


