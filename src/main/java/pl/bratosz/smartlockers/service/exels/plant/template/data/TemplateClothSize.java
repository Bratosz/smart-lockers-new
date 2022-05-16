package pl.bratosz.smartlockers.service.exels.plant.template.data;

import pl.bratosz.smartlockers.model.clothes.ClothSize;
import pl.bratosz.smartlockers.strings.MyString;

public class TemplateClothSize {
    private ClothSize clothSize;

    public TemplateClothSize(String size) {
        size = MyString.create(size).get();
        clothSize = ClothSize.getSizeByName(size);
    }

    public ClothSize getClothSize() {
        return clothSize;
    }
}
