# ShareModule

**Suppose** contain：

+ 应用通用自定义业务组件
+ Apply common custom components

**Suppose** export all included modules.

**NOT Suppose** having `providers` class。

## Custom global components or directives

Each component or directive should have a complete documentation，**Recommend** A reasonable directory structure should be:

```
├── components
│   ├── comp1
│   │   ├── index.ts
│   │   ├── README.md
│   ├── comp2
│   │   ├── index.ts
│   │   ├── README.md
├── directives
│   ├── dire1
│   │   ├── index.ts
│   │   ├── README.md
│   ├── dire2
│   │   ├── index.ts
│   │   ├── README.md
```
