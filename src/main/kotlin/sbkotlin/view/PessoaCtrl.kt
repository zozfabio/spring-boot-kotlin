package sbkotlin.view

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import sbkotlin.domain.Pessoa
import sbkotlin.domain.PessoaRepository
import javax.validation.Valid

@Controller @RequestMapping("/") class PessoaCtrl @Autowired constructor(val repository: PessoaRepository) {
    private fun defaultAttrs(model: Model) = model.mergeAttributes(mapOf("list" to repository.findAll(), "pessoa" to Pessoa()))

    @RequestMapping fun home(model: Model) : String {
        defaultAttrs(model);
        return "home";
    };

    @RequestMapping("/{id}") fun edit(@PathVariable id : Long, model: Model) : String {
        model.addAttribute("pessoa", repository.findOne(id));
        defaultAttrs(model);
        return "home";
    };

    @RequestMapping(method = arrayOf(RequestMethod.POST)) fun save(@Valid @ModelAttribute pessoa: Pessoa, result: BindingResult, model: Model) : String {
        if (result.hasErrors()) {
            defaultAttrs(model);
            return "home";
        }
        repository.save(pessoa);
        return "redirect:/";
    };

    @RequestMapping("/delete/{id}", method = arrayOf(RequestMethod.POST)) fun delete(@PathVariable id : Long) : String {
        repository.delete(id);
        return "redirect:/";
    };
}