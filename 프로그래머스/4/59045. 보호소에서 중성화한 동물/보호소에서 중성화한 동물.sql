-- 코드를 입력하세요
SELECT ao.animal_id, ao.animal_type, ao.name
FROM animal_outs ao
JOIN animal_ins ai
ON ao.animal_id = ai.animal_id
WHERE ao.sex_upon_outcome != ai.sex_upon_intake
ORDER BY ao.animal_id;