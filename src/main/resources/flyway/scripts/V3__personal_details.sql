CREATE TABLE IF NOT EXISTS profile.personal_details
(
    customer_id uuid        NOT NULL REFERENCES customers,
    given_name  text        NOT NULL,
    family_name text        NOT NULL,
    birth_date  date        NOT NULL,
    created_at  timestamptz NOT NULL DEFAULT now(),
    updated_at  timestamptz NOT NULL DEFAULT now(),

    PRIMARY KEY (customer_id)
);
