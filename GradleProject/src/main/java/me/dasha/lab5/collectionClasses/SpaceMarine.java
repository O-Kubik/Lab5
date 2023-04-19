package me.dasha.lab5.collectionClasses;

import me.dasha.lab5.collection.GeneratorID;

import java.time.LocalDateTime;
import java.util.Objects;

public class SpaceMarine {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double health; //Значение поля должно быть больше 0
    private String achievements; //Поле может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(String name, Coordinates coordinates, double health, String achievements, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = GeneratorID.generateID();
        this.name = name;
        this.creationDate = LocalDateTime.now();
        this.coordinates = coordinates;
        this.health = health;
        this.achievements = achievements;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public SpaceMarine(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, double health, String achievements, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = GeneratorID.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.health = health;
        this.achievements = achievements;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public long compareTo(SpaceMarine spaceMarineID) {
        return (this.id - spaceMarineID.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceMarine product = (SpaceMarine) o;
        return id.equals(product.id) &&
                Objects.equals(name, product.name) &&
                coordinates.equals(product.coordinates) &&
                creationDate.equals(product.creationDate) &&
                Objects.equals(health, product.health);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, health);
    }

}
