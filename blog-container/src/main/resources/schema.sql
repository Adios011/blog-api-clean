DROP TABLE IF EXISTS posts;

CREATE TABLE posts
(
    id         CHAR(36) PRIMARY KEY,
    title      VARCHAR(255)  NOT NULL,
    content    VARCHAR(1500) NOT NULL,
    category   ENUM (
        'TECHNOLOGY',
        'HEALTH_AND_WELLNESS',
        'LIFESTYLE',
        'EDUCATION',
        'FOOD_AND_COOKING',
        'HOME_AND_GARDEN',
        'PARENTING_AND_FAMILY',
        'TRAVEL',
        'ARTS_AND_ENTERTAINMENT',
        'SPORTS_AND_FITNESS',
        'SCIENCE_AND_ENVIRONMENT',
        'SELF_IMPROVEMENT',
        'DIY_CRAFTS',
        'REAL_ESTATE_AND_HOME_BUYING',
        'PETS_AND_ANIMALS'
        )                    NOT NULL,
    tags       VARCHAR(255),
    author_id  CHAR(36) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO posts (id, title, content, category, tags, author_id)
VALUES ('1e9a674b-1b6a-4b2a-8f3f-3b9d1d32b812', 'Introduction to Hibernate',
        'This post covers the basics of Hibernate.', 'TECHNOLOGY',
        'Hibernate,ORM,Java', '3c4a574d-3f6a-4f2b-9b3f-6c9d4e43b912');

INSERT INTO posts (id, title, content, category, tags, author_id)
VALUES ('2f9b574c-2b7a-4c3b-8g4f-4c9e1d43c813', 'Health Benefits of Meditation',
        'Meditation offers numerous health benefits.', 'HEALTH_AND_WELLNESS',
        'Health,Meditation,Mindfulness', '4d5a685e-4g7b-5f3c-0h6g-5d0f5f54c923');

INSERT INTO posts (id, title, content, category, tags, author_id)
VALUES ('3g0c684d-3c8a-5d4c-9h5g-5d0f6f64d034', 'Advancements in AI',
        'This post explores recent advancements in AI technology.', 'TECHNOLOGY',
        'AI,Machine Learning,Deep Learning', '5e6b796f-5h8c-6g4d-1i7h-6e1g6g75d145');

